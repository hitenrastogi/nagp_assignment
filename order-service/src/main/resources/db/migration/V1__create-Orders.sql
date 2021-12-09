CREATE TABLE orders (
    id BIGINT IDENTITY (1,1) NOT NULL,
    status VARCHAR (128) NOT NULL,
    customer_name VARCHAR (256) NOT NULL,
    product_name VARCHAR (128) NOT NULL,
    create_date DATETIME NOT NULL
);