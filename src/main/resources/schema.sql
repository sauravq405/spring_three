-- Create the schema (if it doesn't exist)
CREATE SCHEMA IF NOT EXISTS EMP_SCHEMA;

-- Create sequence for auto-increment ID in the schema
CREATE SEQUENCE emp_schema.EMPLOYEE_SEQ START WITH 1 INCREMENT BY 1;

-- Create table in the schema
CREATE TABLE EMP_SCHEMA.EMPLOYEE (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(100) NOT NULL,
    DEPARTMENT VARCHAR2(50),
    SALARY NUMBER(10, 2)
);


