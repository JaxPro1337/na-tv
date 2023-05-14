insert into channels(name,logo,is_active,order_num) values('НТС','https://natv.kg/cache/files/1305.jpg_w130_h65_resize.jpg', 'true',1);
insert into channels(name,logo,is_active,order_num) values('КТРК','https://natv.kg/cache/files/1289.jpg_w130_h65_resize.jpg', 'true',3);
insert into channels(name,logo,is_active,order_num) values('ЛЮБИМЫЙ HD + CINEMAX HD','https://natv.kg/cache/files/2150.jpg_w130_h65_resize.jpg', 'true',1);
insert into channels(name,logo,is_active,order_num) values('ТНТ КЫРГЫЗСТАН','https://natv.kg/cache/files/1363.gif_w130_h65_resize.gif', 'true',2);
insert into channels(name,logo,is_active,order_num) values('СЕМЕЙНЫЙ + ДОМАШНИЙ','https://natv.kg/cache/files/1356.gif_w130_h65_resize.gif', 'true',4);

insert into discounts(percent,from_days_count,channels,start_date,ent_date) values(5,3,1,'20230425','29991231');
insert into discounts(percent,from_days_count,channels,start_date,ent_date) values(10,7,1,'20230425','29991231');
insert into discounts(percent,from_days_count,channels,start_date,ent_date) values(15,10,1,'20230425','29991231');

insert into prices(price,start_date,end_date,channels) values(6,'20230425','29991231',1);
insert into prices(price,start_date,end_date,channels) values(7,'20230425','29991231',2);
insert into prices(price,start_date,end_date,channels) values(5,'20230425','29991231',3);
insert into prices(price,start_date,end_date,channels) values(6,'20230425','29991231',4);
insert into prices(price,start_date,end_date,channels) values(4,'20230425','29991231',5);