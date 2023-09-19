package com.example.Training.Dao;
import com.example.Training.Model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectedPersonByID(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();

    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> personMaybe = selectedPersonByID(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonByID(UUID id) {
        return selectedPersonByID(id)
                .map(person -> {
                    int indexOfPersonToDelet = DB.indexOf(person);
                    if (indexOfPersonToDelet >=0) {
                        DB.set(indexOfPersonToDelet, person);
                        return  1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int updatePersonByID(UUID id, Person newPerson) {
        return 0;
    }
}
