package pl.project.projectPRA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.projectPRA.Entities.Car;
import pl.project.projectPRA.Services.CarService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarContoller {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> list(Model model) {
        return carService.listAllCars();
    }

    @ApiIgnore
    @RequestMapping(value = "/cars", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> redirect(Model model) {
        return carService.listAllCars();
    }

    @GetMapping(value = "/car/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getByPublicId(@PathVariable("id") Integer publicId) {
        return carService.getCarById(publicId).orElseGet(null);
    }

    @GetMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getByParamPublicId(@RequestParam("id") Integer publicId) {
        return carService.getCarById(publicId).orElseGet(null);
    }


    @PutMapping(value = "/car")
    public ResponseEntity<Void> edit(@RequestBody Car car) {
        if(!carService.checkIfExist(car.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            carService.saveCar(car);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PostMapping(value = "/car")
    public ResponseEntity<Car> create(@RequestBody @NonNull @Valid
                                                 Car car) {
        carService.saveCar(car);
        return ResponseEntity.ok().body(car);
    }

    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/cars/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    @GetMapping(value = "/cars/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Car> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return carService.listAllCarsPaging(pageNr, howManyOnPage.orElse(2));
    }
}
