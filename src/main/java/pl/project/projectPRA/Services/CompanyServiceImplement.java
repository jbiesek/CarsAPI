package pl.project.projectPRA.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.project.projectPRA.Entities.Company;
import pl.project.projectPRA.Repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplement implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Iterable<Company> listAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Integer id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (companyRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }

    @Override
    public Iterable<Company> listAllCompaniesPaging(Integer pageNr, Integer howManyOnPage) {
        return companyRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }

    @Override
    public List<Company> getByName(String name) {
        return companyRepository.findByName(name);
    }
}
