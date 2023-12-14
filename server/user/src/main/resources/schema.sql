-- Users Table
CREATE TABLE IF NOT EXISTS `Users`
(
    user_id
    int
    PRIMARY
    KEY,
    unique_id
    VARCHAR
(
    255
) NOT NULL,
    username VARCHAR
(
    255
) NOT NULL,
    email VARCHAR
(
    255
) NOT NULL,
    mobile_number VARCHAR
(
    20
) NOT NULL,
    password VARCHAR
(
    255
) NOT NULL,
    profile_picture_url VARCHAR
(
    255
),
    bio TEXT,
    join_date DATETIME,
    last_login DATETIME
    );

-- Followers Table
CREATE TABLE IF NOT EXISTS `Followers`
(
    follower_id
    int
    PRIMARY
    KEY,
    user_id
    INT
    REFERENCES
    Users
(
    user_id
),
    follower_user_id INT REFERENCES Users
(
    user_id
)
    );

-- Role Table
CREATE TABLE IF NOT EXISTS `Role`
(
    role_id   INT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

-- Permission Table
CREATE TABLE IF NOT EXISTS `Permission`
(
    permission_id   INT PRIMARY KEY,
    permission_name VARCHAR(255) NOT NULL
);

-- UserRole Table (Intermediate Table)
CREATE TABLE IF NOT EXISTS `UserRole`
(
    user_role_id INT PRIMARY KEY,
    user_id      INT REFERENCES Users (user_id),
    role_id      INT REFERENCES Role (role_id),
    UNIQUE (user_id, role_id) -- Ensures a user has a role only once
);

-- PermissionRole Table (Intermediate Table)
CREATE TABLE IF NOT EXISTS `PermissionRole`
(
    permission_role_id INT PRIMARY KEY,
    permission_id      INT REFERENCES Permission (permission_id),
    role_id            INT REFERENCES Role (role_id),
    UNIQUE (permission_id, role_id) -- Ensures a role has a permission only once
);

-- SubscriptionClassification Table
CREATE TABLE IF NOT EXISTS `SubscriptionClassification`
(
    subscription_id   INT PRIMARY KEY,
    user_id           INT REFERENCES Users (user_id),
    classification_id INT,
    UNIQUE (user_id, classification_id) -- Ensures a user is interested in a classification only once
);
