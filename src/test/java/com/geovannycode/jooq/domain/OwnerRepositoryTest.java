package com.geovannycode.jooq.domain;


import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Test
    void createOwner() {
        OwnerWithCars owner = new OwnerWithCars(null, "Manuel", "Gonzalez", List.of());

        OwnerWithCars savedOwner = ownerRepository.createOwner(owner);
        assertThat(savedOwner.ownerId()).isNotNull();
        assertThat(savedOwner.firstName()).isEqualTo("Manuel");
        assertThat(savedOwner.lastName()).isEqualTo("Gonzalez");
    }

    @Test
    void updateOwner() {
        OwnerWithCars owner = createTestOwner();
        OwnerWithCars updateOwner = new OwnerWithCars(owner.ownerId(), "TestName1", owner.lastName(), List.of());
        ownerRepository.updateOwner(updateOwner);

        OwnerWithCars updatedOwner = ownerRepository.findOwnerById(updateOwner.ownerId()).orElseThrow();

        assertThat(updatedOwner.ownerId()).isEqualTo(updatedOwner.ownerId());
        assertThat(updatedOwner.firstName()).isEqualTo("TestName1");
        assertThat(updatedOwner.lastName()).isEqualTo(owner.lastName());
    }

    @Test
    void deleteUser() {
        OwnerWithCars owner = createTestOwner();
        ownerRepository.deleteOwner(owner.ownerId());

        Optional<OwnerWithCars> optionalOwner = ownerRepository.findOwnerById(owner.ownerId());
        assertThat(optionalOwner).isEmpty();
    }

    private OwnerWithCars createTestOwner() {
        String uuid = UUID.randomUUID().toString();
        OwnerWithCars owner = new OwnerWithCars(null, uuid, uuid+"1", List.of());
        return ownerRepository.createOwner(owner);
    }

}
