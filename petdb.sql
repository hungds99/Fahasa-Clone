CREATE SCHEMA `petdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

USE `petdb`;

-- Category
CREATE TABLE `category` (
	id int auto_increment,
    category_name nvarchar(100),
    title nvarchar(100),
    category_breadcrumb nvarchar(255),
    keyword nvarchar(255),
    descriptions nvarchar(255),
    parent_id int NULL,
    primary key(id)
) ;

-- Discount
CREATE TABLE `discount` (
	id int auto_increment,
    discount_name nvarchar(100),
    discount_value int,
    discount_type nvarchar(100),
	discount_code varchar(10),
    detail nvarchar(100),
    primary key (id)
); 

-- Promotion
CREATE TABLE `promotion` (
	id int auto_increment,
    promotion_name nvarchar(100),
    promotion_value int,
    promotion_type nvarchar(100),
	promotion_code varchar(10),
    promotion_rule nvarchar(255),
    created_date date,
    begin_date date,
    end_date date,
    primary key (id)
);

-- Customer
CREATE TABLE `customer` (
	id int auto_increment,
    customer_name nvarchar(100),
    address nvarchar(100),
    gender char(1),
    birthday date,
    phone int,
    email varchar(45),
    username varchar(45),
    password varchar(45),
    primary key (id)
); 

-- Product
CREATE TABLE `product` (
	id int auto_increment,
    product_name nvarchar(100),
    product_price double,
    product_finalprice double,
    product_code int,
    created_date date,
    product_amount int,
    product_status int,
    product_content text,
    highlight boolean,
    isshowed boolean,
    discount_id int,
    promotion_id int,
    category_id int,
    primary key (id)
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
	id int auto_increment,
    image_url varchar(255),
    image_alt nvarchar(255),
    display_order int,
    product_id int,
    promotion_id int,
    primary key(id)
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
	id int auto_increment,
    author_age int,
    author_name nvarchar(100),
    author_info text,
    author_image nvarchar(100),
    primary key (id)
);

-- Publisher 
CREATE TABLE `publisher` (
	id int auto_increment,
    publisher_name nvarchar(100),
    publisher_image nvarchar(100),
    publisher_info nvarchar(255),
    primary key (id)
);

-- Supplier
CREATE TABLE `supplier` (
	id int auto_increment,
    supplier_name nvarchar(100),
    supplier_image nvarchar(100),
    primary key (id)
); 
    
-- Product Attribute
CREATE TABLE `product_attribute` (
	id int auto_increment,
    attr_code int,
    attr_language varchar(45),
    attr_age int,
    attr_layout nvarchar(100),
    attr_page int,
    attr_weight double,
    attr_size varchar(100),
    publish_year int,
    author_id int,
    publisher_id int,
    supplier_id int,
    product_id int,
    primary key(id)
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
	id int auto_increment,
    content text,
    rate int,
    created_date date,
    product_id int,
    customer_id int,
	primary key (id)
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
	id int auto_increment,
    order_status varchar(100),
    created_date date,
    paymethod varchar(100),
    customer_id int,
    primary key (id)
); 

ALTER TABLE `order`
ADD CONSTRAINT fk_order_customer_id
	FOREIGN KEY (customer_id)
    REFERENCES `customer` (id);

-- Order Detail
CREATE TABLE `order_detail` (
	id int auto_increment,
    order_price double,
    order_amount int,
    product_id int,
    order_id int,
    primary key (id)
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
	id int auto_increment,
    username varchar(100),
    email varchar(100),
    password varchar(100),
    primary key (id)
); 

CREATE TABLE `role` (
	id int auto_increment,
    role varchar(100),
    user_id int,
    primary key (id)
);

ALTER TABLE `role`
ADD CONSTRAINT fk_role_user_id
	FOREIGN KEY (user_id)
    REFERENCES `user` (id);
 