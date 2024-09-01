package com.geovannycode.jooq.domain;

public record Car(
        Long idCar,
        String brand,
        String color,
        String model,
        Integer modelYear,
        String registrationNumber,
        Double price) {
}
