create database db_annotations;
create user 'annotationsuser'@'localhost' identified by 'passwordannots1234';
grant all on db_annotations.* to 'annotationsuser'@'localhost';


INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

