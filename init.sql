SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS `users`;
CREATE DATABASE IF NOT EXISTS `products`;


CREATE USER 'users'@'%' IDENTIFIED BY 'dev00_users';
CREATE USER 'users_slave'@'%' IDENTIFIED BY 'dev00_users';

GRANT SELECT,UPDATE,DELETE,INSERT ON `users`.* TO 'users'@'%';
GRANT SELECT ON `users`.* TO 'users_slave'@'%';

CREATE USER 'products'@'%' IDENTIFIED BY 'dev00_products';
CREATE USER 'products_slave'@'%' IDENTIFIED BY 'dev00_products';

GRANT SELECT,UPDATE,DELETE,INSERT ON `products`.* TO 'products'@'%';
GRANT SELECT ON `products`.* TO 'products_slave'@'%';

FLUSH PRIVILEGES;


