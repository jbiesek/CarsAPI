package pl.project.projectPRA.Services;

import pl.project.projectPRA.Entities.Dealer;

import java.util.List;
import java.util.Optional;

public interface DealerService {
    Iterable<Dealer> listAllDealers();

    Optional<Dealer> getDealerById(Integer id);

    Dealer saveDealer(Dealer dealer);

    void deleteDealer(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Dealer> listAllDealersPaging(Integer pageNr, Integer howManyOnPage);

    List<Dealer> getByName(String name);
}
