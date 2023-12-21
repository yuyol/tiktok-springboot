-- Videos Table
CREATE TABLE IF NOT EXISTS `Videos` (
    video_id Long PRIMARY KEY,
    yv VARCHAR(255) DEFAULT NULL,
    user_id Long NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT DEFAULT NULL,
    url VARCHAR(255) DEFAULT NULL,
    classification_id Long NOT NULL,
    upload_date DATETIME,
    duration INT,
    video_cover_url VARCHAR(255),
    audit_result INT,
    audit_label VARCHAR(255),
    audit_state VARCHAR(255),
    likes_count INT DEFAULT 0,
    comments_count INT DEFAULT 0,
    views_count INT DEFAULT 0,
    shares_count INT DEFAULT 0,
    favorites_count INT DEFAULT 0,
--     '逻辑删除，0：未删除，1：删除，默认为0'
    open INT NOT NULL DEFAULT 0,
    gmt_created DATETIME DEFAULT NULL,
    gmt_updated DATETIME DEFAULT NULL
);

-- Table structure for favorites
CREATE TABLE IF NOT EXISTS `Favorites` (
    id Long PRIMARY KEY,
    name VARCHAR(255) DEFAULT NULL,
    description VARCHAR(255) DEFAULT NULL,
    user_id Long NOT NULL,
    is_deleted INT DEFAULT 0,
    gmt_created DATETIME DEFAULT NULL,
    gmt_updated DATETIME DEFAULT NULL
);

-- Table structure for favorites_video
CREATE TABLE IF NOT EXISTS `Favorites_video` (
    id Long PRIMARY KEY,
    favorites_id Long NOT NULL,
    user_id Long NOT NULL,
    video_id Long NOT NULL,
    UNIQUE (favorites_id,video_id,user_id)
);

-- Likes Table
CREATE TABLE IF NOT EXISTS `Likes` (
    id Long PRIMARY KEY,
    user_id Long NOT NULL,
    video_id Long NOT NULL,
    gmt_created DATETIME DEFAULT NULL,
    UNIQUE (user_id,video_id)
);

-- Comments Table
CREATE TABLE IF NOT EXISTS `Comments` (
    id Long PRIMARY KEY,
    user_id Long NOT NULL,
    video_id Long NOT NULL,
    comment TEXT,
    gmt_created DATETIME DEFAULT NULL
);

-- VideoSharing Table
CREATE TABLE IF NOT EXISTS `Video_sharing` (
    id LONG PRIMARY KEY,
    video_id Long NOT NULL,
    user_id Long NOT NULL,
    ip VARCHAR(45) DEFAULT NULL,
    gmt_created datetime DEFAULT NULL,
    gmt_updated datetime DEFAULT NULL,
    UNIQUE(ip, video_id)
);

-- VideoClassification Table (Middle Table)
CREATE TABLE IF NOT EXISTS `Video_classification` (
    id LONG PRIMARY KEY,
    video_id LONG,
    classification_id LONG,
    is_deleted INT DEFAULT 0,
    gmt_created datetime DEFAULT NULL,
    gmt_updated datetime DEFAULT NULL,
    UNIQUE(video_id, classification_id)
);

-- Classification Table
CREATE TABLE IF NOT EXISTS `Classification` (
    id LONG PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    icon VARCHAR(255),
    tag_name VARCHAR(255) NOT NULL,
    is_deleted INT,
    gmt_created datetime DEFAULT NULL,
    gmt_updated datetime DEFAULT NULL
);