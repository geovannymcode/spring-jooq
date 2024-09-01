package com.geovannycode.jooq.domain;

import java.util.List;

public record Owner(
        Long ownerId,
        String firstName,
        String lastName,
        List<Car> cars
) {
}
