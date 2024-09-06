package com.geovannycode.jooq.domain;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.geovannycode.jooq.generated.tables.Owner.OWNER;
import static com.geovannycode.jooq.generated.tables.Car.CAR;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

@Repository
public class OwnerRepository {

    private final DSLContext dsl;

    public OwnerRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<OwnerWithCars> findAllOwners() {
        return dsl
                .select(OWNER.OWNER_ID, OWNER.FIRST_NAME, OWNER.LAST_NAME)
                .from(OWNER)
                .fetch(r -> new OwnerWithCars(
                        r.get(OWNER.OWNER_ID),
                        r.get(OWNER.FIRST_NAME),
                        r.get(OWNER.LAST_NAME),
                        List.of())
                );
    }

    public Optional<OwnerWithCars> findOwnerById(Long id) {
        return dsl
                .select(OWNER.OWNER_ID, OWNER.FIRST_NAME, OWNER.LAST_NAME,
                        multiset(select(CAR.CAR_ID, CAR.BRAND, CAR.COLOR, CAR.MODEL, CAR.MODEL_YEAR, CAR.REGISTRATION_NUMBER, CAR.PRICE)
                                .from(CAR)
                                .where(CAR.OWNER_ID.eq(OWNER.OWNER_ID))
                        ).as("cars").convertFrom(r -> r.map(record -> new OwnerWithCars.Car(
                                record.get(CAR.CAR_ID),
                                record.get(CAR.BRAND),
                                record.get(CAR.COLOR),
                                record.get(CAR.MODEL),
                                record.get(CAR.MODEL_YEAR),
                                record.get(CAR.REGISTRATION_NUMBER),
                                record.get(CAR.PRICE).doubleValue()
                        )))
                )
                .from(OWNER)
                .where(OWNER.OWNER_ID.eq(id))
                .fetchOptional()
                .map(mapping(OwnerWithCars::new));
    }
}
