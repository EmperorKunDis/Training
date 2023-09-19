package com.example.Training.Service;

import com.example.Training.Dao.PersonDao;
import com.example.Training.Model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonDao personDao;

        public PersonService(PersonDao personDao) {
            this.personDao = personDao;
        }
        public int addPerson(Person person) {
            return personDao.insertPerson(person);
        }
}
