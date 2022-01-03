package pl.project.projectPRA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.project.projectPRA.Entities.Transaction;
import pl.project.projectPRA.Repositories.TransactionRepository;

import java.util.Optional;

@Service
public class TransactionServiceImplement implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Iterable<Transaction> listAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (transactionRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Transaction> listAllTransactionsPaging(Integer pageNr, Integer howManyOnPage) {
        return transactionRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    /*@Override
    public Iterable<Transaction> getTransactionByOwnerId(Integer id) {
        return transactionRepository.getTransactionByOwnerId(id);
    }

    @Override
    public List<Transaction> getTransactionsAndCarsByPersonId(Integer id){
        return transactionRepository.getTransactionsAndCarsByPersonId(id);
    }*/

}
