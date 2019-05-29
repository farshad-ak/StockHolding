delete from stockdb.stock;
delete from stockdb.sale;
delete from stockdb.product;
delete from stockdb.product_sales;
--------------------------------
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('vegetable-123','vegetable 123 description','vegetable-123 name',1000,'');
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('apple1','apple apple','apple benana',2000,'');
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('apple2','apple apple','apple benana',3000,'');
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('apple3','apple apple','apple benana',4000,'');
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('apple4','apple apple','apple benana',5000,'');
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('apple5','apple apple','apple benana',6000,'');
INSERT  INTO stockdb.product(id, description, name, price_per_unit, tag) values ('apple6','apple apple','apple benana',7000,'');
---------------------------------
INSERT  INTO stockdb.sale(id, count_of_item, price_per_unit, total_price, product_id,sale_date) values (1,2,1000,2000,'vegetable-123','2019-04-29 10:54:01.754000');
INSERT  INTO stockdb.sale(id, count_of_item, price_per_unit, total_price, product_id,sale_date) values (2,5,1000,5000,'apple1','2019-02-20 10:54:01.754000');
INSERT  INTO stockdb.sale(id, count_of_item, price_per_unit, total_price, product_id,sale_date) values (3,6,1000,6000,'vegetable-123','2019-05-29 10:54:01.754000');
INSERT  INTO stockdb.sale(id, count_of_item, price_per_unit, total_price, product_id,sale_date) values (4,1,1000,1000,'apple5','2019-05-29 12:54:01.754000');
----------------------------------
INSERT INTO stockdb.stock (id, last_update_stock, quantity, version, product_id) VALUES ('00001', '2019-05-29 02:54:01.754000', 3600, 0, 'vegetable-123');
INSERT INTO stockdb.stock (id, last_update_stock, quantity, version, product_id) VALUES ('00002', '2018-07-17 22:54:01.754000', 1000, 0, 'apple5');
INSERT INTO stockdb.stock (id, last_update_stock, quantity, version, product_id) VALUES ('00003', '2018-08-17 22:54:01.754000', 5000, 0, 'apple6');
INSERT INTO stockdb.stock (id, last_update_stock, quantity, version, product_id) VALUES ('00004', '2019-05-29 10:54:01.754000', 5000, 0, 'apple4');
