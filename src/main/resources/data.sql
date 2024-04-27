create table sell_details
(
    id                   bigserial
        primary key,
    customer_id          bigint,
    customer_name        varchar(255),
    product_id           bigint,
    product_name         varchar(255),
    status               varchar(255),
    total_amount         double precision,
    total_unit           bigint,
    unit_price           double precision,
    created_at_dt        timestamp(6),
    created_by           bigint,
    created_by_user_name varchar(255),
    created_dt           date,
    deleted_at_dt        timestamp(6),
    deleted_by           bigint,
    deleted_by_user_name varchar(255),
    deleted_dt           date,
    updated_at_dt        timestamp(6),
    updated_by           bigint,
    updated_by_user_name varchar(255),
    updated_dt           date
);

alter table sell_details
    owner to admin;



insert into sell_details(product_id, product_name, total_unit, unit_price, total_amount, customer_id, customer_name,
                         status, created_at_dt, created_dt)
values (1, 'Bag', 1, 100, 100, 1, 'samrat', 'Active', current_timestamp, '2024-04-12'),
       (2, 'Mouse', 2, 60, 120, 2, 'samrat2', 'Active', current_timestamp, '2024-04-14'),
       (1, 'Bag', 1, 100, 100, 1, 'samrat', 'Active', current_timestamp, '2024-04-16'),
       (2, 'Mouse', 2, 60, 120, 1, 'samrat', 'Active', current_timestamp, '2024-04-18'),
       (1, 'Bag', 1, 100, 100, 2, 'samrat2', 'Active', current_timestamp, '2024-04-12'),
       (3, 'Keyboard', 1, 500, 500, 1, 'samrat', 'Active', current_timestamp, '2024-04-20'),
       (3, 'Keyboard', 2, 500, 1000, 1, 'samrat', 'Active', current_timestamp, '2024-04-22'),
       (3, 'Keyboard', 1, 500, 500, 1, 'samrat', 'Active', current_timestamp, '2024-04-02'),
       (2, 'Mouse', 2, 60, 120, 2, 'samrat2', 'Active', current_timestamp, '2024-04-23');