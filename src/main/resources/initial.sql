create database if not exists gallery;

-- MariaDB
-- SELECT DATABASE();

use gallery;

create table person (
    id bigint auto_increment primary key,
    email varchar(255) not null,
    user_name varchar(255) null,
    user_type varchar(255) null
);

create table `group` (
   id bigint auto_increment primary key,
   group_name varchar(255) not null,
   parent_id bigint null
);

create table card (
  id bigint auto_increment primary key,
  title varchar(255) null,
-- tbd
  group_id bigint null,
  description varchar(255) null,
-- tbd
  dpi smallint null,
-- tbd
  link varchar(2083) null,
-- constraints
  foreign key (group_id) references `group` (id)
);



