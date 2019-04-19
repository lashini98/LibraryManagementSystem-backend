# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table w1698510_book (
  w1698510_isbn                 varchar(255) not null,
  w1698510_title                varchar(255),
  w1698510_sector               varchar(255),
  w1698510_publication_date     varchar(255),
  w1698510_total_pages          integer,
  w1698510_book_author          varchar(255),
  w1698510_book_publisher       varchar(255),
  constraint pk_w1698510_book primary key (w1698510_isbn)
);

create table w1698510_dvd (
  w1698510_isbn                 varchar(255) not null,
  w1698510_title                varchar(255),
  w1698510_sector               varchar(255),
  w1698510_publication_date     varchar(255),
  w1698510_avail_languages      varchar(255),
  w1698510_avail_subtitles      varchar(255),
  w1698510_dvd_producer         varchar(255),
  w1698510_dvd_actors           varchar(255),
  constraint pk_w1698510_dvd primary key (w1698510_isbn)
);

create table w1698510_itemsborrowed (
  w1698510_borrow_id            bigint auto_increment not null,
  w1698510_user_id              varchar(255),
  w1698510_user_name            varchar(255),
  w1698510_contact_no           varchar(255),
  w1698510_user_email           varchar(255),
  w1698510_borrow_date          varchar(255) not null,
  w1698510_return_date          varchar(255) not null,
  w1698510_isbn                 varchar(255) not null,
  w1698510_item_type            tinyint(1) default 0 not null,
  w1698510_is_returned          tinyint(1) default 0 not null,
  w1698510_item_amount          varchar(255),
  constraint pk_w1698510_itemsborrowed primary key (w1698510_borrow_id)
);


# --- !Downs

drop table if exists w1698510_book;

drop table if exists w1698510_dvd;

drop table if exists w1698510_itemsborrowed;

