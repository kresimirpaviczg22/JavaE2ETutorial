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