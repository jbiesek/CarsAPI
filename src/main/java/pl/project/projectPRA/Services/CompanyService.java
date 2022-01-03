package pl.project.projectPRA.Services;

import pl.project.projectPRA.Entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Iterable<Company> listAllCompanies();

    Optional<Company> getCompanyById(Integer id);

    Company saveCompany(Company comapny);

    void deleteCompany(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Company> listAllCompaniesPaging(Integer pageNr, Integer howManyOnPage);

    List<Company> getByName(String name);
}
