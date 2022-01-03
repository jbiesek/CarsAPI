package pl.project.projectPRA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.project.projectPRA.Entities.Dealer;
import pl.project.projectPRA.Repositories.DealerRepository;
import java.util.List;

import java.util.Optional;

@Service
public class DealerServiceImplement implements DealerService {
    @Autowired
    private DealerRepository dealerRepository;

    @Override
    public Iterable<Dealer> listAllDealers() {
        return dealerRepository.findAll();
    }

    @Override
    public Optional<Dealer> getDealerById(Integer id) {
        return dealerRepository.findById(id);
    }

    @Override
    public Dealer saveDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @Override
    public void deleteDealer(Integer id) {
        dealerRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (dealerRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Dealer> listAllDealersPaging(Integer pageNr, Integer howManyOnPage) {
        return dealerRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    public List<Dealer> getByName(String name) {
        return dealerRepository.findByName(name);
    }
}
