package pl.project.projectPRA.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.project.projectPRA.Entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>, PagingAndSortingRepository<Transaction, Integer> {
    @Query("select count(*) from Transaction t where t.id = ?1")
    Integer checkIfExist(Integer id);

   // @Query("select * from transaction t where t.owner_id = ?1")
    //List<Transaction> getTransactionByOwnerId(Integer id);

    //@Query("SELECT t. date, c.vin, c.brand, c.model, c.year, p. pesel, p.name, p.surname FROM transaction t JOIN car c ON c.id = t.car_id JOIN person p ON p.id = t.owner_id WHERE p.id = 1")
    //List<Transaction> getTransactionsAndCarsByPersonId(Integer id);
}
