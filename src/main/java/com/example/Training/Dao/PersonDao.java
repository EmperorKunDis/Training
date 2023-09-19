package com.example.Training.Dao;

import com.example.Training.Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();

    Optional<Person> selectedPersonByID(UUID id);

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id);

    int updatePersonByID(UUID id, Person newPerson);
}
