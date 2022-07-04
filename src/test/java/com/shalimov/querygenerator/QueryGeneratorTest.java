package com.shalimov.querygenerator;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorTest {
    private QueryGenerator queryGenerator = new QueryGenerator();

    @Test
    public void testFindAll() {
        String actualQuery = queryGenerator.findAll(Person.class);
        String expectedQuery = "SELECT id, person_name, person_salary FROM Person;";
        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testFindById() {
        String actualQuery = queryGenerator.findById(Person.class, 1101);
        String expectedQuery = "SELECT id, person_name, person_salary FROM Person WHERE id = 1101;";
        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testInsert() {
        Person newPerson = new Person(1101, "Alex", 5000.0);
        String actualQuery = queryGenerator.insert(newPerson);
        String expectedQuery = "INSERT INTO Person (id, person_name, person_salary) VALUES (1101, 'Alex', 5000.0);";
        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testDelete() {
        String actualQuery = queryGenerator.delete(Person.class, 1101);
        String expectedQuery = "DELETE FROM Person WHERE id = 1101;";
        assertEquals(expectedQuery, actualQuery);
    }

    @Test
    public void testUpdate() {
        Person newPerson = new Person(1101, "Alex", 5000);
        String actualQuery = queryGenerator.update(newPerson);
        String expectedQuery = "UPDATE Person SET person_name = 'Alex', person_salary = 5000.0 WHERE id = 1101;";
        assertEquals(expectedQuery, actualQuery);
    }
}