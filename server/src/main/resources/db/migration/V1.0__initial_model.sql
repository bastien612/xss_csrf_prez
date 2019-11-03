create table category (
    id BIGINT PRIMARY KEY,
    name TEXT,
    created_at DATE,
    updated_at DATE
);

create table product (
    id BIGINT PRIMARY KEY,
    name text,
    created_at DATE,
    updated_at DATE
);

create table category_product (
    product_id BIGINT references product(id),
    category_id BIGINT references category(id)
);

--create table rel_product_list (
--    id BIGINT PRIMARY KEY,
--    title text,
--    created_at DATE,
--    updated_at DATE
--);
--
--create table rel_product_list(
--    product_id BIGINT REFERENCES product(id),
--    product_list_id BIGINT REFERENCES product_list(id)
--);