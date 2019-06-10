CREATE TABLE itens
(
    item_id VARCHAR(5) NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (item_id)
);

CREATE TABLE requests
(
    request_id VARCHAR(5) NOT NULL,
    item_id VARCHAR(5) NOT NULL,
    request_quantity INTEGER NOT NULL,
    PRIMARY KEY (request_id)
);
