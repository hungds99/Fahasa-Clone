CREATE SCHEMA `petdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `petdb`;

-- Category
CREATE TABLE `category` (
    id INT AUTO_INCREMENT,
    category_name NVARCHAR(100),
    title NVARCHAR(100),
    category_breadcrumb NVARCHAR(255),
    keyword NVARCHAR(255),
    descriptions NVARCHAR(255),
    parent_id INT NULL,
    PRIMARY KEY (id)
);

-- Insert Category data
INSERT INTO `category` (id, category_breadcrumb, category_name, descriptions, keyword, parent_id, title) VALUES 
(1,'>>', 'Sách Trong Nước', 'sách hay', 'hay nhat', 0, 'Tổng hợp sách hay nhất'),
(2,'>>', 'Văn học', 'sách hay', 'hay nhat', 1, 'Tổng hợp sách nhất');

-- Discount
CREATE TABLE `discount` (
    id INT AUTO_INCREMENT,
    discount_name NVARCHAR(100),
    discount_value INT,
    discount_type NVARCHAR(100),
    discount_code VARCHAR(10),
    detail NVARCHAR(100),
    PRIMARY KEY (id)
);

-- Promotion
CREATE TABLE `promotion` (
    id INT AUTO_INCREMENT,
    promotion_name NVARCHAR(100),
    promotion_value INT,
    promotion_type NVARCHAR(100),
    promotion_code VARCHAR(10),
    promotion_rule NVARCHAR(255),
    used_valid BOOLEAN,
    created_date DATE,
    begin_date DATE,
    end_date DATE,
    PRIMARY KEY (id)
);

-- Customer
CREATE TABLE `customer` (
    id INT AUTO_INCREMENT,
    name NVARCHAR(100),
    address NVARCHAR(100),
    gender CHAR(1),
    birthday DATE,
    phone INT,
    email VARCHAR(45),
    username VARCHAR(45),
    password VARCHAR(100),
    PRIMARY KEY (id)
);

-- Product
CREATE TABLE `product` (
    id INT AUTO_INCREMENT,
    product_name NVARCHAR(100),
    product_price DOUBLE,
    product_finalprice DOUBLE,
    product_code INT,
    created_date DATE,
    product_amount INT,
    product_status INT,
    product_content TEXT,
    highlight BOOLEAN,
    isshowed BOOLEAN,
    discount_id INT,
    promotion_id INT,
    category_id INT,
    PRIMARY KEY (id)
);

-- Foreign Key 
ALTER TABLE `product` 
ADD CONSTRAINT fk_product_discount_id
	FOREIGN KEY (discount_id)
	REFERENCES `discount` (id);
    
ALTER TABLE `product`
ADD CONSTRAINT fk_product_promotion_id
	FOREIGN KEY (promotion_id)
    REFERENCES `promotion` (id);

ALTER TABLE `product`
ADD CONSTRAINT fk_product_category_id
	FOREIGN KEY (category_id)
    REFERENCES `category` (id);
    
CREATE TABLE `image` (
    id INT AUTO_INCREMENT,
    image_url VARCHAR(255),
    image_alt NVARCHAR(255),
    display_order INT,
    product_id INT,
    promotion_id INT,
    PRIMARY KEY (id)
);

-- Foreign Key
ALTER TABLE `image` 
ADD	CONSTRAINT fk_image_product_id
	FOREIGN KEY (product_id)
    REFERENCES `product` (id);

ALTER TABLE `image`
ADD CONSTRAINT fk_image_promotion_id
	FOREIGN KEY (promotion_id)
    REFERENCES `promotion` (id);

-- Author
CREATE TABLE `author` (
    id INT AUTO_INCREMENT,
    author_age INT,
    author_name NVARCHAR(100),
    author_info TEXT,
    author_image NVARCHAR(100),
    PRIMARY KEY (id)
);

-- Publisher 
CREATE TABLE `publisher` (
    id INT AUTO_INCREMENT,
    publisher_name NVARCHAR(100),
    publisher_image NVARCHAR(100),
    publisher_info NVARCHAR(255),
    PRIMARY KEY (id)
);

-- Supplier
CREATE TABLE `supplier` (
    id INT AUTO_INCREMENT,
    supplier_name NVARCHAR(100),
    supplier_image NVARCHAR(100),
    PRIMARY KEY (id)
);
    
-- Product Attribute
CREATE TABLE `product_attribute` (
    id INT AUTO_INCREMENT,
    attr_code INT,
    attr_language VARCHAR(45),
    attr_age INT,
    attr_layout NVARCHAR(100),
    attr_page INT,
    attr_weight DOUBLE,
    attr_size VARCHAR(100),
    publish_year INT,
    author_id INT,
    publisher_id INT,
    supplier_id INT,
    product_id INT,
    PRIMARY KEY (id)
);

ALTER TABLE `product_attribute`
ADD CONSTRAINT fk_product_attribute_author_id
	FOREIGN KEY (author_id)
    REFERENCES `author` (id);
    
ALTER TABLE `product_attribute`
ADD CONSTRAINT fk_product_attribute_publisher_id
	FOREIGN KEY (publisher_id)
    REFERENCES `publisher` (id);
    
ALTER TABLE `product_attribute`
ADD CONSTRAINT fk_product_attribute_supplier_id
	FOREIGN KEY (supplier_id)
    REFERENCES `supplier` (id);

-- Comment
CREATE TABLE `comment` (
    id INT AUTO_INCREMENT,
    content TEXT,
    rate INT,
    created_date DATE,
    product_id INT,
    customer_id INT,
    PRIMARY KEY (id)
);

-- Foreign Key
ALTER TABLE `comment`
ADD CONSTRAINT fk_comment_product_id
	FOREIGN KEY (product_id)
    REFERENCES `product` (id);

ALTER TABLE `comment`
ADD CONSTRAINT fk_comment_customer_id
	FOREIGN KEY (customer_id)
    REFERENCES `customer` (id);

-- Order
CREATE TABLE `order` (
    id INT AUTO_INCREMENT,
    order_status VARCHAR(100),
    created_date DATE,
    paymethod VARCHAR(100),
    customer_id INT,
    PRIMARY KEY (id)
); 

ALTER TABLE `order`
ADD CONSTRAINT fk_order_customer_id
	FOREIGN KEY (customer_id)
    REFERENCES `customer` (id);

-- Order Detail
CREATE TABLE `order_detail` (
    id INT AUTO_INCREMENT,
    order_price DOUBLE,
    order_amount INT,
    product_id INT,
    order_id INT,
    PRIMARY KEY (id)
);

-- Foreign Key
ALTER TABLE `order_detail` 
ADD CONSTRAINT fk_order_detail_product_id
	FOREIGN KEY (product_id)
    REFERENCES `product` (id);

ALTER TABLE `order_detail`
ADD CONSTRAINT fk_order_detail_order_id
	FOREIGN KEY (order_id)
    REFERENCES `order` (id);

-- User Admin
CREATE TABLE `user` (
    id INT AUTO_INCREMENT,
    username VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE `role` (
    id INT AUTO_INCREMENT,
    role VARCHAR(100),
    user_id INT,
    PRIMARY KEY (id)
);

ALTER TABLE `role`
ADD CONSTRAINT fk_role_user_id
	FOREIGN KEY (user_id)
    REFERENCES `user` (id);
 