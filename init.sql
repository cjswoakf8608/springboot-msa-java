SET NAMES utf8mb4;

CREATE DATABASE IF NOT EXISTS `users`;
CREATE DATABASE IF NOT EXISTS `payments`;


CREATE USER 'users'@'%' IDENTIFIED BY 'dev00_users';
CREATE USER 'users_slave'@'%' IDENTIFIED BY 'dev00_users';

GRANT SELECT,UPDATE,DELETE,INSERT ON `users`.* TO 'users'@'%';
GRANT SELECT ON `users`.* TO 'users_slave'@'%';

CREATE USER 'payments'@'%' IDENTIFIED BY 'dev00_payments';
CREATE USER 'payments_slave'@'%' IDENTIFIED BY 'dev00_payments';

GRANT SELECT,UPDATE,DELETE,INSERT ON `payments`.* TO 'payments'@'%';
GRANT SELECT ON `payments`.* TO 'payments_slave'@'%';

FLUSH PRIVILEGES;


