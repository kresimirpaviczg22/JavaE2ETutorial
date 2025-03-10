create sequence public.hibernate_sequence increment 1 start 1 minvalue 1;
create sequence public.contract_seq increment 50 start 1 minvalue 1;

create table contract (
  id bigint primary key not null,
  name varchar(255) not null,
  number varchar(255) not null,
  year int not null,
  type varchar(64) not null,
  version varchar(16) not null,
  start_date timestamp,
  end_date timestamp
);

create sequence public.organisation_seq increment 50 start 1 minvalue 1;

create table organisation (
  id bigint primary key not null,
  name varchar(255) not null,
  address varchar(255),
  city varchar(255),
  state varchar(255),
  country varchar(255),
  founded_date timestamp not null
);

create sequence public.users_seq increment 50 start 1 minvalue 1;

create table users (
  id bigint primary key not null,
  organisation_id bigint not null,
  username varchar(255) not null,
  email varchar(255),
  active varchar(3) not null,
  foreign key (organisation_id) references organisation(id) on delete cascade
);

