package mezin.danil.services;

import mezin.danil.models.Car;
import mezin.danil.models.Person;
import mezin.danil.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Object findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void save(@Valid Person person) {
        enrichPerson(person);
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person personToUpdated) {
        personToUpdated.setDateOfCreateAccount(personRepository.findById(id).get().getDateOfCreateAccount());
        personToUpdated.setId(id);
        personRepository.save(personToUpdated);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public List<Car> getCarsByPersonId(int id) {
        Optional<Person> person = personRepository.findById(id);
        return person.get().getCars();
    }

    public Optional<Person> getPersonByName(String name) {
        return personRepository.findByName(name);
    }

    private void enrichPerson(Person person) {
        person.setDateOfCreateAccount(new Date());
    }
}
