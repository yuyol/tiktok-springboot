-- Table structure for Product
CREATE TABLE IF NOT EXISTS `ProductName` (
    id Long PRIMARY KEY,
    name VARCHAR(255) DEFAULT NULL,
    gmt_created DATETIME DEFAULT NULL,
    gmt_updated DATETIME DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `ProductInfo` (
    id Long PRIMARY KEY,
    description TEXT DEFAULT NULL,
    price Float NOT NULL,
    is_deleted INT DEFAULT 0,
    gmt_created DATETIME DEFAULT NULL,
    gmt_updated DATETIME DEFAULT NULL
);

-- Table structure for Category
create table if not exists `Category` (
    id Long primary key,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS `ProductCategory` (
    id Long primary key,
    product_name_id Long,
    user_id Long,
    category_id Long
);

-- Table structure for Type
create table if not exists `Type` (
    id Long primary key,
    name VARCHAR(255) NOT NULL,
    product_id Long
);

CREATE TABLE IF NOT EXISTS `ProductType` (
    id Long primary key,
    product_name_id Long,
    user_id Long,
    type_id Long
);

CREATE TABLE IF NOT EXISTS `ProductInfoType` (
    id Long primary key,
    product_info_id Long,
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
    gmt_created DATETIME DEFAULT NULL,
    gmt_updated DATETIME DEFAULT NULL
);

-- Table structure for Comment
create table if not exists `Comment`(
    id Long primary key,
    comment TEXT,
    user_id Long,
    rating float,
    gmt_created DATETIME DEFAULT NULL,
    gmt_updated DATETIME DEFAULT NULL
);

-- Table structure for Follower
create table if not exists `Follower`(
    id Long primary key,
    seller_id Long,
    follower_user_id Long
);