package pl.project.projectPRA.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.projectPRA.Entities.Transaction;
import pl.project.projectPRA.Services.TransactionService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionsController {
    @Autowired
    private TransactionService transactionService;

    //list all transactions
    @GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Transaction> list(Model model) {
        return transactionService.listAllTransactions();
    }

    @ApiIgnore
    @RequestMapping(value = "/transactions", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Transaction> redirect(Model model) {
        return transactionService.listAllTransactions();
    }

    //list transaction by id
    @GetMapping(value = "/transaction/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction getByPublicId(@PathVariable("id") Integer publicId) {
        return transactionService.getTransactionById(publicId).orElseGet(null);
    }

    @GetMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction getByParamPublicId(@RequestParam("id") Integer publicId) {
        return transactionService.getTransactionById(publicId).orElseGet(null);
    }

    //edit transaction
    @PutMapping(value = "/transaction")
    public ResponseEntity<Void> edit(@RequestBody Transaction transaction) {
        if(!transactionService.checkIfExist(transaction.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            transactionService.saveTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    //save transaction
    @PostMapping(value = "/transaction")
    public ResponseEntity<Transaction> create(@RequestBody @NonNull @Valid
                                                 Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return ResponseEntity.ok().body(transaction);
    }

    //delete transaction
    @DeleteMapping(value = "/transaction/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/transactions/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    @GetMapping(value = "/transactions/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Transaction> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return transactionService.listAllTransactionsPaging(pageNr, howManyOnPage.orElse(2));
    }

/*    @GetMapping(value = "/transaction/query/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Transaction> getTransactionByOwnerId(@PathVariable Integer id){
        return transactionService.getTransactionByOwnerId(id);
    }


    @GetMapping(value="transactions/query/{id}")
    public List<Transaction> getTransactionsCarsAndOwners(@PathVariable Integer id){
        return transactionService.getTransactionsAndCarsByPersonId(id);
    }*/
}
