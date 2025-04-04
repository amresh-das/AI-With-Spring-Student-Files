-- Schema for HyperSQL database
-- TDODO-03: Observe the database schema below.
-- This information will be passed to the model for SQL generation.

-- Creating PRODUCT table
CREATE TABLE PRODUCT (
    PRODUCT_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    DESCRIPTION VARCHAR(255) NOT NULL,
    SALES_PRICE DECIMAL(10, 2) NOT NULL
);

-- Creating SALES_HISTORY table
CREATE TABLE SALES_HISTORY (
    SALES_HISTORY_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PRODUCT_ID INTEGER,
    WEEK_START_DATE DATE NOT NULL,
    QUANTITY_SOLD INTEGER NOT NULL,
    SALES_AMOUNT DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
);

-- Creating INVENTORY_HISTORY table
CREATE TABLE INVENTORY_HISTORY (
    INVENTORY_HISTORY_ID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PRODUCT_ID INTEGER,
    WEEK_START_DATE DATE NOT NULL,
    STOCK_QUANTITY INTEGER NOT NULL,
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
);
