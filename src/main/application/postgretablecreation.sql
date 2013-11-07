CREATE TABLE IF NOT EXISTS base.EMPLOYEE 
(
    ID          integer PRIMARY KEY DEFAULT nextval('base.serial'),
    FIRSTNAME   VARCHAR(30),
    LASTNAME    VARCHAR(30),
    TELEPHONE   VARCHAR(15),
    EMAIL       VARCHAR(30),
    datecreated date,
    CREATED     timestamp DEFAULT current_timestamp
);