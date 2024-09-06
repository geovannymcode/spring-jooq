package com.geovannycode.jooq.domain;

import com.geovannycode.jooq.generated.tables.Owner;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.jooq.SelectConditionStep;
import org.jooq.SelectSelectStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.geovannycode.jooq.generated.tables.Car.CAR;
import static com.geovannycode.jooq.generated.tables.Owner.OWNER;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@Sql("classpath:/test-data.sql")
@JooqTest
@Import({OwnerRepository.class})
@ExtendWith(MockitoExtension.class)
public class OwnerRepositoryTest {

    @Mock
    private DSLContext dsl;

    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testFindAllOwners() {
        List<OwnerWithCars> owners = ownerRepository.findAllOwners();
        assertThat(owners).hasSize(2);
    }

    @Test
    void getOwnerWithCars() {
        Optional<OwnerWithCars> ownerOptional = ownerRepository.findOwnerById(2L);
        assertThat(ownerOptional).isPresent();
        OwnerWithCars owner = ownerOptional.get();
        assertThat(owner.ownerId()).isEqualTo(2L);
        assertThat(owner.firstName()).isEqualTo("Geovanny");
        assertThat(owner.lastName()).isEqualTo("Mendoza");

        assertThat(owner.cars()).hasSize(2);

        var car1 = new OwnerWithCars.Car(2L, "Toyota", "Red", "Corolla", 2020, "ABC123", 20000.0);
        var car2 = new OwnerWithCars.Car(3L, "Honda", "Blue", "Civic", 2019, "XYZ789", 18000.0);

        assertThat(owner.cars()).contains(car1, car2);
    }

}
