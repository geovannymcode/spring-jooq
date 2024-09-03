package com.geovannycode.jooq.domain;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.geovannycode.jooq.generated.tables.Owner.OWNER;

@Repository
public class OwnerRepository {

    private final DSLContext dsl;

    public OwnerRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<Owner> findAllOwners() {
        return dsl
                .select(OWNER.OWNERID, OWNER.FIRSTNAME, OWNER.LASTNAME)
                .from(OWNER)
                .fetch(r -> new Owner(
                        r.get(OWNER.OWNERID),
                        r.get(OWNER.FIRSTNAME),
                        r.get(OWNER.LASTNAME),
                        List.of())
                );
    }
}
