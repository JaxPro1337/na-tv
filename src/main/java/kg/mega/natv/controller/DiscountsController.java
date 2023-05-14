package kg.mega.natv.controller;


import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.entity.Discounts;
import kg.mega.natv.service.DiscountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discounts")
public class DiscountsController {
    private final DiscountsService discountsService;

    @PostMapping("/create")
    public ResponseEntity<?> createDiscounts(@RequestBody DiscountDto discountDto){
        return ResponseEntity.ok(discountsService.createDiscounts(discountDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findDiscountsById(@PathVariable Long id){
        return ResponseEntity.ok(discountsService.findDiscountsById(id));
    }
    @GetMapping("/find-all")
    public ResponseEntity<?> findAllDiscounts(){
        return ResponseEntity.ok(discountsService.findAllDiscounts());
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateDiscounts(@RequestBody Discounts discounts){
        return ResponseEntity.ok(discountsService.updateDiscounts(discounts));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiscounts(@PathVariable Long id){
        return ResponseEntity.ok(discountsService.deleteDiscounts(id));
    }

}
