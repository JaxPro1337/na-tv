package kg.mega.natv.service.impl;

import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.dto.OrderChannelDto;
import kg.mega.natv.models.dto.OrderDto;

import kg.mega.natv.models.dto.OrderResponseDto;
import kg.mega.natv.models.entity.OrderChannels;
import kg.mega.natv.models.entity.OrderDays;
import kg.mega.natv.models.entity.Orders;
import kg.mega.natv.models.enums.Status;
import kg.mega.natv.models.mapper.OrderMapper;
import kg.mega.natv.repository.OrderChannelRepo;
import kg.mega.natv.repository.OrderDaysRepo;
import kg.mega.natv.repository.OrdersRepo;
import kg.mega.natv.service.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Service
public class OrdersServiceImpl implements OrdersService {

    private final DiscountsService discountsService;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final OrdersRepo ordersRepo;
    private final OrderDaysRepo orderDaysRepo;
    private final PricesService pricesService;
    private final ChannelsService channelsService;
    private final OrderChannelRepo orderChannelRepo;

    public OrdersServiceImpl(DiscountsService discountsService, OrdersRepo ordersRepo, OrderDaysRepo orderDaysRepo, PricesService pricesService, ChannelsService channelsService, OrderChannelRepo orderChannelRepo) {
        this.discountsService = discountsService;
        this.ordersRepo = ordersRepo;
        this.orderDaysRepo = orderDaysRepo;
        this.pricesService = pricesService;
        this.channelsService = channelsService;
        this.orderChannelRepo = orderChannelRepo;
    }


    @Override
    public OrderResponseDto appendOrder(OrderDto orderDto) {


        // удалить все лишние пробелы из текста
        orderDto.setAdjText(orderDto.getAdjText().trim().replaceAll("\\s+", " "));
        // посчитать количество символов без учета пробелов
        Integer countOfChars = orderDto.getAdjText().trim().replaceAll("\\s+", "").length();

        // создаем через маппер объет класса Order
        Orders orders = Orders
                .builder()
                .orderText(orderDto.getAdjText())
                .customersName(orderDto.getCustomer())
                .email(orderDto.getEmail())
                .status(Status.CREATED)
                .phoneNumber(orderDto.getPhoneNumber())
                .build();
        // сохраняем заявку
        Orders savedOrder = ordersRepo.save(orders);

        Double totalPrice = 0.0;
        Double totalAfterDiscounts = 0.0;


        // создаем цикл по каналам
        for (OrderChannelDto orderChannelDto: orderDto.getChannels()) {
            // по количеству дней на рекламу ищем возможную максимальную скидку по id канала
            DiscountDto discountDto = discountsService.findDiscountsByOrderChannelDto(orderChannelDto);

            // вычисляем стоимость с учетом скидки и без, прибавляем их в общим суммам соответственно
            Double price = pricesService.getPriceByChannel(orderChannelDto.getChannelId()).getPrice();
            Double totalPriceWithOutDiscount = price * countOfChars * orderChannelDto.getAdDates().size();
            totalPrice += totalPriceWithOutDiscount;

            if (discountDto == null) {
                discountDto = DiscountDto
                        .builder()
                        .percent(0)
                        .build();
            }
            Double totalPriceWithDiscount = totalPriceWithOutDiscount - (discountDto.getPercent() * totalPriceWithOutDiscount / 100);
            totalAfterDiscounts += totalPriceWithDiscount;
            // создаем OrderChannel
            OrderChannels orderChannels = OrderChannels
                    .builder()
                    .channelsId(channelsService.findChannelsById(orderChannelDto.getChannelId()))
                    .orders(orders)
                    .price(totalPriceWithDiscount)
                    .build();
            // сохраняем
            orderChannelRepo.save(orderChannels);

            //создаем список OrderDays
            OrderDays orderDays = OrderDays
                    .builder()
                    .orderChannels(orderChannels)
                    .day(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
            // сохраняем
            orderDaysRepo.save(orderDays);

        }
        savedOrder.setTotalPrice(totalPrice);
        savedOrder.setTotalAfterDiscount(totalAfterDiscounts);
        ordersRepo.save(savedOrder);

        // создаем OrderResponseDto из Order,
        OrderResponseDto orderResponseDto = orderMapper.entityToDto(orders);


        return orderResponseDto;
    }
}
