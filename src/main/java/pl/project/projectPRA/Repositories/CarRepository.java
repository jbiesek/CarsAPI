package pl.project.projectPRA.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.project.projectPRA.Entities.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer>, PagingAndSortingRepository<Car, Integer> {
    @Query("select count(*) from Car c where c.id = ?1")
    Integer checkIfExist(Integer id);

}
