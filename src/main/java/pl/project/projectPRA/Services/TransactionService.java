package pl.project.projectPRA.Services;

import pl.project.projectPRA.Entities.Transaction;

import java.util.Optional;

public interface TransactionService {
    Iterable<Transaction> listAllTransactions();

    Optional<Transaction> getTransactionById(Integer id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Transaction> listAllTransactionsPaging(Integer pageNr, Integer howManyOnPage);

    //List<Transaction> getTransactionsAndCarsByPersonId(Integer id);

    //Iterable<Transaction> getTransactionByOwnerId(Integer id);
}
