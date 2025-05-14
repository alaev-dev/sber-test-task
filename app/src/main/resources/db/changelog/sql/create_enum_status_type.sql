create type status_enum as enum ('processed','failed');

alter table message drop column status;

alter table message add column status status_enum;