CREATE TABLE ItemDetails (
    id INT PRIMARY KEY,
    electronics_id VARCHAR2(25),
    title NVARCHAR2(255) NOT NULL,
    short_desc NVARCHAR2(255) NOT NULL,
    long_desc NVARCHAR2(4000),
    price NUMBER(10,2) NOT NULL,
    CONSTRAINT fk_itemdetails_electronics FOREIGN KEY (electronics_id) REFERENCES Electronics(id)
);