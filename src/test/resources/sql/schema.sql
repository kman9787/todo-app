CREATE TABLE IF NOT EXISTS `todo` (

    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `created_datetime` TIMESTAMP,
    `desc` VARCHAR(255),
    `title` VARCHAR(255),
    `updated_datetime` TIMESTAMP

);

CREATE TABLE IF NOT EXISTS `users` (

    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `password` VARCHAR(255),
    `roles` VARCHAR(255),
    `user_name` VARCHAR(255)

);