create table customer (
    id uuid PRIMARY KEY,
    login TEXT,
    password TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);