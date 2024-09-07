package com.geovannycode.jooq.domain;

import java.util.List;

public record OwnerWithCars(
        Long ownerId,
        String firstName,
        String lastName,
        List<Car> cars
) {
    public record Car(
            Long idCar,
            String brand,
            String color,
            String model,
            Integer modelYear,
            String registrationNumber,
            Double price) {
    }

    public static OwnerWithCars create(Long ownerId,
                                       String firstName,
                                       String lastName) {
        return new OwnerWithCars(ownerId, firstName, lastName, null);
    }
}
