package pl.project.projectPRA.Services;


import pl.project.projectPRA.Entities.Person;
import java.util.Optional;
public interface PersonService {
    Iterable<Person> listAllPeople();

    Optional<Person> getPersonById(Integer id);

    Person savePerson(Person person);

    void deletePerson(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Person> listAllPeoplePaging(Integer pageNr, Integer howManyOnPage);
}
