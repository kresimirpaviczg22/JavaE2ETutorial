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

-- car i engine

create sequence public.cars_seq increment 50 start 1 minvalue 1;

create table cars (
	id bigint primary key not null,
	engine_id bigint not null,
	vin varchar(17) not null,
	make varchar(255) not null,
	model varchar(255) not null,
	manufacturing_year int not null
);

create sequence public.engines_seq increment 50 start 1 minvalue 1;

create table engines (
	id bigint primary key not null,
	manufacturer varchar(255) not null,
	model varchar(255) not null,
	manufacturing_year int not null,
	volume int, -- electric engines do not measure in volume (cc)
	engine_type varchar(255) not null
);

alter table engines drop column car_id;