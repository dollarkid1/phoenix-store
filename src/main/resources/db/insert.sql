set foreign_key_checks = 0;

truncate table product;
truncate table item;
truncate table cart;
truncate table app_user;
truncate table cart_item_list;


insert into product(id, name, price, quantity)
values(12, 'Luxury Mop', 2340, 3),
(13, 'Macbook Air', 18320, 4),
(14, 'Rocking chair', 5340, 5),
(15, 'Purple T-shirt', 7340, 7);


insert into item (id, product_id, quantity_added_to_cart)
values (340,333, 3320);


insert into cart(id,total_price)
values (123,0.0),
       (124,0.0),
       (125,0.0);


insert into app_user(id, firstname, lastname, email, my_cart_id)
values(5005, 'John', 'Lee', 'john@email.com', 123 ),
      (5010, 'Chris', 'Tuck', 'chris@myspace.com',124 ),
      (5011, 'Fred', 'Tim', 'Fred@myspace.com',125 );


insert into cart_item_list (cart_id, item_list_id)
values (234, 510),
       (234, 511),
       (234, 512);

set foreign_key_checks = 1;
