package pl.project.projectPRA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.project.projectPRA.Entities.Car;
import pl.project.projectPRA.Repositories.CarRepository;

import java.util.Optional;

@Service
public class CarServiceImplement implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Iterable<Car> listAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (carRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Car> listAllCarsPaging(Integer pageNr, Integer howManyOnPage) {
        return carRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }


}
