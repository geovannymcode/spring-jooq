CREATE SEQUENCE owner_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE car_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

CREATE TABLE Owner (
                       owner_id BIGINT PRIMARY KEY DEFAULT nextval('owner_seq'),
                       first_name VARCHAR(50),
                       last_name VARCHAR(50)
);

CREATE TABLE Car (
                     car_id BIGINT PRIMARY KEY DEFAULT nextval('car_seq'),
                     brand VARCHAR(50),
                     color VARCHAR(20),
                     model VARCHAR(50),
                     model_year INT,
                     registration_number VARCHAR(20),
                     price DECIMAL(10, 2),
                     owner_id BIGINT,
                     CONSTRAINT FK_CAR_OWNER FOREIGN KEY (owner_id) REFERENCES Owner(owner_id)
);