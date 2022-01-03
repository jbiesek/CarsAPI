package pl.project.projectPRA.Services;

import pl.project.projectPRA.Entities.Car;

import java.util.Optional;

public interface CarService {
    Iterable<Car> listAllCars();

    Optional<Car> getCarById(Integer id);

    Car saveCar(Car car);

    void deleteCar(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Car> listAllCarsPaging(Integer pageNr, Integer howManyOnPage);

}
