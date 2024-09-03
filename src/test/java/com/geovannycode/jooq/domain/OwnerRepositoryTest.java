package com.geovannycode.jooq.domain;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.Result;
import org.jooq.ResultQuery;
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

import java.util.List;
import java.util.Objects;

import static com.geovannycode.jooq.generated.tables.Owner.OWNER;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class OwnerRepositoryTest {

    @Mock
    private DSLContext dsl;

    @InjectMocks
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testFindAllOwners() {
        SelectSelectStep<Record3<Long, String, String>> selectStep = mock(SelectSelectStep.class);
        SelectJoinStep<Record3<Long, String, String>> joinStep = mock(SelectJoinStep.class);
        Result<Record3<Long, String, String>> result = mock(Result.class);

        when(dsl.select(eq(OWNER.OWNERID), eq(OWNER.FIRSTNAME), eq(OWNER.LASTNAME)))
                .thenReturn(selectStep);
        when(selectStep.from(any(Table.class))).thenReturn(joinStep);

        when(joinStep.fetch(any(RecordMapper.class))).thenAnswer(invocation -> {
            RecordMapper<Record3<Long, String, String>, Owner> mapper = invocation.getArgument(0);
            return List.of(
                    mapper.map(mockRecord(1L, "John", "Doe")),
                    mapper.map(mockRecord(2L, "Jane", "Doe"))
            );
        });

        List<Owner> owners = ownerRepository.findAllOwners();

        assertNotNull(owners);

    }

    private Record3<Long, String, String> mockRecord(long id, String firstName, String lastName) {
        Record3<Long, String, String> record = mock(Record3.class);
        when(record.get(OWNER.OWNERID)).thenReturn(id);
        when(record.get(OWNER.FIRSTNAME)).thenReturn(firstName);
        when(record.get(OWNER.LASTNAME)).thenReturn(lastName);
        return record;
    }
}
