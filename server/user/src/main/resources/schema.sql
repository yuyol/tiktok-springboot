-- Users Table
CREATE TABLE IF NOT EXISTS `Users` (
    user_id int PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    profile_picture_url VARCHAR(255),
    bio TEXT,
    join_date DATETIME,
    last_login DATETIME
);

-- Followers Table
CREATE TABLE IF NOT EXISTS `Followers` (
   follower_id int PRIMARY KEY,
   user_id INT REFERENCES Users(user_id),
   follower_user_id INT REFERENCES Users(user_id)
);