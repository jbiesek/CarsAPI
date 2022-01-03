package pl.project.projectPRA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.projectPRA.Entities.Person;
import pl.project.projectPRA.Services.PersonService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    //list all people
    @GetMapping(value = "/people", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> list(Model model) {
        return personService.listAllPeople();
    }

    @ApiIgnore
    @RequestMapping(value = "/people", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> redirect(Model model) {
        return personService.listAllPeople();
    }

    //get person by id
    @GetMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getByPublicId(@PathVariable("id") Integer publicId) {
        return personService.getPersonById(publicId).orElseGet(null);
    }

    @GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getByParamPublicId(@RequestParam("id") Integer publicId) {
        return personService.getPersonById(publicId).orElseGet(null);
    }

    //save person
    @PostMapping(value = "/person")
    public ResponseEntity<Person> create(@RequestBody @NonNull @Valid
                                                  Person person) {
        personService.savePerson(person);
        return ResponseEntity.ok().body(person);
    }

    //edit person
    @PutMapping(value = "/person")
    public ResponseEntity<Void> edit(@RequestBody Person person) {
        if(!personService.checkIfExist(person.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            personService.savePerson(person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    //delete person
    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    @GetMapping(value = "/people/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return personService.listAllPeoplePaging(pageNr, howManyOnPage.orElse(2));
    }
}
