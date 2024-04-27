insert into sell_details(product_id, product_name, total_unit, unit_price, total_amount, customer_id, customer_name,
                         status, created_at_dt)
values (1, 'Bag', 1, 100, 100, 1, 'samrat', 'Active', current_timestamp),
       (2, 'Mouse', 2, 60, 120, 2, 'samrat2', 'Active', current_timestamp),
       (1, 'Bag', 1, 100, 100, 1, 'samrat', 'Active', current_timestamp),
       (2, 'Mouse', 2, 60, 120, 1, 'samrat', 'Active', current_timestamp),
       (1, 'Bag', 1, 100, 100, 2, 'samrat2', 'Active', current_timestamp),
       (3, 'Keyboard', 1, 500, 500, 1, 'samrat', 'Active', current_timestamp),
       (3, 'Keyboard', 2, 500, 1000, 1, 'samrat', 'Active', current_timestamp),
       (3, 'Keyboard', 1, 500, 500, 1, 'samrat', 'Active', current_timestamp),
       (2, 'Mouse', 2, 60, 120, 2, 'samrat2', 'Active', current_timestamp);