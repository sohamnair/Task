CREATE TABLE Electronics (
    id VARCHAR2(25) PRIMARY KEY,
    category_id VARCHAR2(25),
    CONSTRAINT fk_electronics_category FOREIGN KEY (category_id) REFERENCES ProductCategory(category_id)
);