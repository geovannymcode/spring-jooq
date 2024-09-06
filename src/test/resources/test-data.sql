INSERT INTO owner (owner_id, first_name, last_name)
VALUES
    (1, 'Elena', 'Aguirre'),
    (2,'Geovanny', 'Mendoza');

INSERT INTO car (car_id, brand, color, model, model_year, registration_number, price, owner_id)
VALUES
    (1,'Honda', 'Blue', 'Civic', 2019, 'XYZ456', 18000.00, 1),
    (2, 'Toyota', 'Red', 'Corolla', 2020, 'ABC123', 20000.00, 2),
    (3, 'Honda', 'Blue', 'Civic', 2019, 'XYZ789', 18000.0, 2);
