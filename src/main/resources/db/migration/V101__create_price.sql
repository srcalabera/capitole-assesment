drop table if exists "prices";

create table  "prices" (
    "id" integer primary key AUTOINCREMENT,
    "brand_id" bigint not null,
    "start_date" timestamp not null,
    "end_date" timestamp not null,
    "price_list" bigint not null,
    "product_id" bigint not null,
    "price" NUMERIC(20, 2) not null,
    "curr" varchar(3) not null,
    FOREIGN KEY (brand_id) REFERENCES brand(id)
);