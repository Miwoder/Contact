package fio.service;

import fio.entity.Person;

import fio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    public  void addNewPerson(Person person){
        personRepository.save(person);
    }
    public  void deletePerson(Person person ){
        personRepository.delete(person);
    }
    public  void editPerson(Person person){
        personRepository.save(person);
    }
    public Optional<Person> getById(long id) {
        return personRepository.findAllById(id);
    }
}