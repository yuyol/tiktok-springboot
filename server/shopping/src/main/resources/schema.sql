-- Table structure for Product
CREATE TABLE IF NOT EXISTS `Product_Name` (
    id Long PRIMARY KEY,
    name VARCHAR(255) DEFAULT NULL,
    gmt_created date DEFAULT NULL,
    gmt_updated date DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `Product_Info` (
    id Long PRIMARY KEY,
    description TEXT DEFAULT NULL,
    price Float NOT NULL,
    is_deleted INT DEFAULT 0,
    user_id Long NOT NULL,
    product_name_id Long NOT NULL,
    type_id Long NOT NULL,
    gmt_created date DEFAULT NULL,
    gmt_updated date DEFAULT NULL
);

-- Table structure for Category
create table if not exists `Category` (
    id Long primary key,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS `Product_Category` (
    id Long primary key,
    product_name_id Long,
    user_id Long,
    category_id Long
);

-- Table structure for Type
create table if not exists `Type` (
    id Long primary key,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Product_Type` (
    id Long primary key,
    product_name_id Long,
    user_id Long,
    type_id Long
);

CREATE TABLE IF NOT EXISTS `Product_Info_Type` (
    id Long primary key,
    product_info_id Long,
    product_name_id Long,
    user_id Long,
    type_id Long
);


-- Table structure for Seller
create table if not exists `Seller`(
    id Long primary key,
    product_name_id Long,
    product_info_id Long,
    user_id Long
);

-- Table structure for Inventory
CREATE table IF NOT EXISTS `Inventory` (
    id Long PRIMARY KEY,
    product_id Long,
    type_id Long,
    quantity Long,
    gmt_created date DEFAULT NULL,
    gmt_updated date DEFAULT NULL
);

-- Table structure for Comment
create table if not exists `Comment`(
    id Long primary key,
    comment TEXT,
    user_id Long,
    rating float,
    gmt_created date DEFAULT NULL,
    gmt_updated date DEFAULT NULL
);

-- Table structure for Follower
create table if not exists `Follower`(
    id Long primary key,
    seller_id Long,
    follower_user_id Long
);