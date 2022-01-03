package pl.project.projectPRA.Controllers;

import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.project.projectPRA.Entities.Company;
import pl.project.projectPRA.Services.CompanyService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Company> list(Model model) {
        return companyService.listAllCompanies();
    }

    @ApiIgnore
    @DeleteMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Company> redirect(Model model) {
        return companyService.listAllCompanies();
    }

    @PostMapping(value = "/company")
    public ResponseEntity<Company> create(@RequestBody @Validated(Company.class) @NonNull Company company){
        companyService.saveCompany(company);
        return ResponseEntity.ok().body(company);
    }

    @PutMapping(value = "/company/{id}")
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        companyService.deleteCompany(id);
        return new RedirectView("/api/company", true);
    }

    @GetMapping(value = "company/{name}")
    public List<Company> getByName(@PathVariable String name){
        return companyService.getByName(name);
    }

    @GetMapping(value = "/company/{id}", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Integer publicId) {
        Optional<Company> company = companyService.getCompanyById(publicId);
        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else
            return ResponseEntity.noContent().build();
    }
}
