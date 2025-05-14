alter type status_enum rename to status_enum_old;

create type status_enum as ENUM('PROCESSED', 'FAILED');

alter table message alter column status TYPE status_enum USING status::text::status_enum;