/*
 * This file is generated by jOOQ.
 */
package com.geovannycode.jooq.generated.tables.daos;


import com.geovannycode.jooq.generated.tables.Car;
import com.geovannycode.jooq.generated.tables.pojos.JooqCar;
import com.geovannycode.jooq.generated.tables.records.CarRecord;

import java.math.BigDecimal;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class CarRepository extends DAOImpl<CarRecord, JooqCar, Long> {

    /**
     * Create a new CarRepository without any configuration
     */
    public CarRepository() {
        super(Car.CAR, JooqCar.class);
    }

    /**
     * Create a new CarRepository with an attached configuration
     */
    @Autowired
    public CarRepository(Configuration configuration) {
        super(Car.CAR, JooqCar.class, configuration);
    }

    @Override
    public Long getId(JooqCar object) {
        return object.getCarId();
    }

    /**
     * Fetch records that have <code>car_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfCarId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Car.CAR.CAR_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>car_id IN (values)</code>
     */
    public List<JooqCar> fetchByCarId(Long... values) {
        return fetch(Car.CAR.CAR_ID, values);
    }

    /**
     * Fetch a unique record that has <code>car_id = value</code>
     */
    public JooqCar fetchOneByCarId(Long value) {
        return fetchOne(Car.CAR.CAR_ID, value);
    }

    /**
     * Fetch records that have <code>brand BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfBrand(String lowerInclusive, String upperInclusive) {
        return fetchRange(Car.CAR.BRAND, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>brand IN (values)</code>
     */
    public List<JooqCar> fetchByBrand(String... values) {
        return fetch(Car.CAR.BRAND, values);
    }

    /**
     * Fetch records that have <code>color BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfColor(String lowerInclusive, String upperInclusive) {
        return fetchRange(Car.CAR.COLOR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>color IN (values)</code>
     */
    public List<JooqCar> fetchByColor(String... values) {
        return fetch(Car.CAR.COLOR, values);
    }

    /**
     * Fetch records that have <code>model BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfModel(String lowerInclusive, String upperInclusive) {
        return fetchRange(Car.CAR.MODEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>model IN (values)</code>
     */
    public List<JooqCar> fetchByModel(String... values) {
        return fetch(Car.CAR.MODEL, values);
    }

    /**
     * Fetch records that have <code>model_year BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfModelYear(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Car.CAR.MODEL_YEAR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>model_year IN (values)</code>
     */
    public List<JooqCar> fetchByModelYear(Integer... values) {
        return fetch(Car.CAR.MODEL_YEAR, values);
    }

    /**
     * Fetch records that have <code>registration_number BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfRegistrationNumber(String lowerInclusive, String upperInclusive) {
        return fetchRange(Car.CAR.REGISTRATION_NUMBER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>registration_number IN (values)</code>
     */
    public List<JooqCar> fetchByRegistrationNumber(String... values) {
        return fetch(Car.CAR.REGISTRATION_NUMBER, values);
    }

    /**
     * Fetch records that have <code>price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(Car.CAR.PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price IN (values)</code>
     */
    public List<JooqCar> fetchByPrice(BigDecimal... values) {
        return fetch(Car.CAR.PRICE, values);
    }

    /**
     * Fetch records that have <code>owner_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<JooqCar> fetchRangeOfOwnerId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Car.CAR.OWNER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>owner_id IN (values)</code>
     */
    public List<JooqCar> fetchByOwnerId(Long... values) {
        return fetch(Car.CAR.OWNER_ID, values);
    }
}
