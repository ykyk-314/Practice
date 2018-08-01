set names utf8;
set foreign_key_checks=0;
drop database if exists ecsite;
create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
  id int not null primary key auto_increment,
  login_id varchar(16) unique,
  login_pass varchar(16),
  user_name varchar(50),
  insert_date datetime,
  updated_date datetime
  );



drop table if exists admin_transaction;

create table admin_transaction(
	id int not null primary key auto_increment,
	admin_id varchar(16) unique,
	admin_pass varchar(16),
	admin_name varchar(50)
	);



drop table if exists items_info_transaction;

create table item_info_transaction(
  id int not null primary key auto_increment,
  item_name varchar(30),
  item_price int,
  item_stock int,
  insert_date datetime,
  update_date datetime
  );



drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
  id int not null primary key auto_increment,
  item_transaction_id int,
  total_price int,
  total_count int,
  user_master_id varchar(16),
  pay varchar(30),
  insert_date datetime,
  delete_date datetime
  );

  INSERT INTO item_info_transaction(item_name,item_price,item_stock)VALUES("NoteBook",100,50);

  INSERT INTO admin_transaction(admin_id,admin_pass,admin_name)VALUES("admin","admin","admin");

