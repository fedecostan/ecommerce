INSERT INTO ecommerce.product_type (id, description) VALUES ('1', 'TV');
INSERT INTO ecommerce.product_type (id, description) VALUES ('2', 'PHONE');
INSERT INTO ecommerce.product_type (id, description) VALUES ('3', 'LAPTOP');

INSERT INTO ecommerce.screen (id, refresh_rate, resolution, inches, technology, type) VALUES ('1', '60', '1920 x 1080', '55', 'LED', 'Flat');
INSERT INTO ecommerce.screen (id, refresh_rate, resolution, inches, technology, type) VALUES ('2', '60', '1280 x 720', '32', 'LCD', 'Flat');
INSERT INTO ecommerce.screen (id, refresh_rate, resolution, inches, technology) VALUES ('3', '60', '1920 x 1080', '5', 'LCD');
INSERT INTO ecommerce.screen (id, refresh_rate, resolution, inches, technology) VALUES ('4', '60', '1920 x 2000', '5.5', 'LCD');
INSERT INTO ecommerce.screen (id, refresh_rate, resolution, inches, technology) VALUES ('5', '120', '1920 x 1080', '15.6', 'LCD');
INSERT INTO ecommerce.screen (id, refresh_rate, resolution, inches, technology, type) VALUES ('6', '60', '1920 x 1080', '17', 'LCD', 'Curve');

INSERT INTO ecommerce.manufacturer (id, code, name) VALUES ('1', '55UM7000', 'LG');
INSERT INTO ecommerce.manufacturer (id, code, name) VALUES ('2', '32SM40HD', 'Samsung');
INSERT INTO ecommerce.manufacturer (id, model, name) VALUES ('3', '11 Pro MAX 256GB', 'IPhone');
INSERT INTO ecommerce.manufacturer (id, model, name) VALUES ('4', 'Pixel 4 128 GB', 'Google');
INSERT INTO ecommerce.manufacturer (id, code, model, name) VALUES ('5', 'ROG531GV', 'ROG Strix', 'Asus');
INSERT INTO ecommerce.manufacturer (id, code, model, name) VALUES ('6', 'ROG731GT', 'ROG Zephyrus G', 'Asus');

INSERT INTO ecommerce.tv_info (id, smart_tv, year, manufacturer_id, screen_id) VALUES ('1', b'1', 2019, '1', '1');
INSERT INTO ecommerce.tv_info (id, smart_tv, year, manufacturer_id, screen_id) VALUES ('2', b'0', 2015, '2', '2');
INSERT INTO ecommerce.phone_info (id, back_camera, battery, front_camera, hard_drive_size, nfc_capable, operating_system, ram_size, sim_type, video_recorder, manufacturer_id, screen_id)
VALUES ('1', '12 mpx', '5000', '8 mpx', '256', b'1', 'IOS 13.0', '4', 'Nano-sim', '4K 30 fps - 1080p 60 fps', '3', '3');
INSERT INTO ecommerce.phone_info (id, back_camera, battery, front_camera, hard_drive_size, nfc_capable, operating_system, ram_size, sim_type, video_recorder, manufacturer_id, screen_id)
VALUES ('2', '25 mpx', '4000', '12 mpx', '128', b'1', 'Android 9', '6', 'Nano-sim', '1080p 60 fps', '4', '4');
INSERT INTO ecommerce.laptop_info (id, camera, graphics, hard_drive_size, operating_system, processor, ram_size, weight, manufacturer_id, screen_id)
VALUES ('1', 'NO', 'RTX 2060', '1 TB', 'NO', 'i7', '16', '1', '5', '5');
INSERT INTO ecommerce.laptop_info (id, camera, graphics, hard_drive_size, operating_system, processor, ram_size, weight, manufacturer_id, screen_id)
VALUES ('2', '720p', 'RTX 2080', '1 TB', 'Windows 10', 'i9', '16', '1', '6', '6');

INSERT INTO ecommerce.product (id, code, discount, price, stock, description, name) VALUES ('1', 'A', '0', '400', '2', 'TV LG LCD 55 Inches', 'TV LG 55');
INSERT INTO ecommerce.product (id, code, discount, price, stock, description, name) VALUES ('2', 'B', '15', '300', '1', 'TV Samsung LCD 32 Inches Used', 'TV Samsung 32');
INSERT INTO ecommerce.product (id, code, discount, price, stock, description, name) VALUES ('3', 'C', '0', '1000', '5', 'IPhone 11 PRO Max 256 GB', 'IPhone 11');
INSERT INTO ecommerce.product (id, code, discount, price, stock, description, name) VALUES ('4', 'D', '10', '900', '3', 'Google Pixel 4 smartphone 128GB', 'Pixel 4');
INSERT INTO ecommerce.product (id, code, discount, price, stock, description, name) VALUES ('5', 'E', '10', '1400', '2', 'i7, RTX 2060, 16, 1TB', 'Asus ROG Strix');
INSERT INTO ecommerce.product (id, code, discount, price, stock, description, name) VALUES ('6', 'F', '0', '3000', '1', 'i9, RTX 2080, 16, 1TB', 'Asus ROG Zephyrus');


INSERT INTO ecommerce.product_detail (id, product_id, product_type_id, tv_info_id)
VALUES ('1', '1', '1', '1');
INSERT INTO ecommerce.product_detail (id, product_id, product_type_id, tv_info_id)
VALUES ('2', '2', '1', '2');
INSERT INTO ecommerce.product_detail (id, product_id, product_type_id, phone_info_id)
VALUES ('3', '3', '2', '1');
INSERT INTO ecommerce.product_detail (id, product_id, product_type_id, phone_info_id)
VALUES ('4', '4', '2', '2');
INSERT INTO ecommerce.product_detail (id, product_id, product_type_id, laptop_info_id)
VALUES ('5', '5', '3', '1');
INSERT INTO ecommerce.product_detail (id, product_id, product_type_id, laptop_info_id)
VALUES ('6', '6', '3', '2');