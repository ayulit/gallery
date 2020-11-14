-- create database if not exists gallery;
-- MariaDB
-- SELECT DATABASE();
-- use gallery;

create table card (
                      id bigint auto_increment primary key,
                      added datetime(6)  null,
                      description varchar(255) null,
                      link varchar(2083) null,
                      dpi smallint null,
                      title varchar(255) null,
                      version bigint null,
                      group_id bigint null
-- tbd
-- tbd
-- tbd
);

create table card_audit
(
    id        bigint auto_increment primary key,
    operation varchar(255) null,
    updated   datetime(6)  null,
    version bigint null,
    card_id   bigint       null
);

create table card_tags
(
    card_id bigint not null,
    tag_id  bigint not null,
    primary key (card_id, tag_id)
);

create table category (
                          id bigint auto_increment primary key,
                          group_name varchar(255) not null
--    parent_id bigint null
);

create table person (
                        id bigint auto_increment primary key,
                        email varchar(255) not null,
                        user_name varchar(255) null,
                        user_type varchar(255) null
);

create table tag
(
    id bigint auto_increment primary key,
    tag_name varchar(255) not null
);

alter table person add constraint UK_person_email
    unique (email);

alter table tag add constraint UK_tag_tag_name
    unique (tag_name);

alter table card add constraint FK_card_category_group_id
    foreign key (group_id) references category (id);

alter table card_audit add constraint FK_card_audit_card_card_id
    foreign key (card_id) references card (id);

alter table card_tags add constraint FK_card_tags_tag_tag_id
    foreign key (tag_id) references tag (id);

alter table card_tags add constraint FK_card_tags_card_tag_id
    foreign key (card_id) references card (id);
