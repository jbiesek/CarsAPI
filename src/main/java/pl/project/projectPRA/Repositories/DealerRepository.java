package pl.project.projectPRA.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.project.projectPRA.Entities.Dealer;

import java.util.List;

@Repository
public interface DealerRepository extends CrudRepository<Dealer, Integer>, PagingAndSortingRepository<Dealer, Integer> {

    List<Dealer> findByName(String name);

    @Query("select count(*) from Dealer d where d.id = ?1")
    Integer checkIfExist(Integer id);

}
