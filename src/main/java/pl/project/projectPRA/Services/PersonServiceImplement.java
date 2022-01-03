package pl.project.projectPRA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.project.projectPRA.Entities.Person;
import pl.project.projectPRA.Repositories.PersonRepository;

import java.util.Optional;

@Service
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> listAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (personRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Person> listAllPeoplePaging(Integer pageNr, Integer howManyOnPage) {
        return personRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
