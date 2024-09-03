CREATE SEQUENCE owner_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE car_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

CREATE TABLE Owner (
                       ownerId BIGINT PRIMARY KEY DEFAULT nextval('owner_seq'),
                       FirstName VARCHAR(50),
                       LastName VARCHAR(50)
);

CREATE TABLE Car (
                     idCar BIGINT PRIMARY KEY DEFAULT nextval('car_seq'),
                     Brand VARCHAR(50),
                     Color VARCHAR(20),
                     Model VARCHAR(50),
                     ModelYear INT,
                     RegistrationNumber VARCHAR(20),
                     Price DECIMAL(10, 2),
                     ownerId BIGINT,
                     CONSTRAINT FK_CAR_OWNER FOREIGN KEY (ownerId) REFERENCES Owner(ownerId)
);