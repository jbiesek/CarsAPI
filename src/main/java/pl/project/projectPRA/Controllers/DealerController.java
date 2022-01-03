package pl.project.projectPRA.Controllers;

import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.project.projectPRA.Entities.Dealer;
import pl.project.projectPRA.Services.DealerService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DealerController {

    @Autowired
    private DealerService dealerService;

    //list all dealers
    @GetMapping(value = "/dealers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Dealer> list(Model model) {
        return dealerService.listAllDealers();
    }

    @ApiIgnore
    @DeleteMapping(value = "/dealers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Dealer> redirect(Model model) {
        return dealerService.listAllDealers();
    }

    //save dealer
    @PostMapping(value = "/dealer")
    public ResponseEntity<Dealer> create(@RequestBody @Validated(Dealer.class) @NonNull Dealer dealer){
        dealerService.saveDealer(dealer);
        return ResponseEntity.ok().body(dealer);
    }

    //edit dealer
    @PutMapping(value = "/dealer/{id}")
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        dealerService.deleteDealer(id);
        return new RedirectView("/api/dealer", true);
    }

    //get dealer by name
    @GetMapping(value = "dealer/{name}")
    public List<Dealer> getByName(@PathVariable String name){
        return dealerService.getByName(name);
    }

    //get dealer by id
    @GetMapping(value = "/dealer/{id}", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Dealer> getDealerByPublicId(@PathVariable("id") Integer publicId) {
        Optional<Dealer> dealer = dealerService.getDealerById(publicId);
        if(dealer.isPresent()) {
            return ResponseEntity.ok(dealer.get());
        } else
            return ResponseEntity.noContent().build();
    }
}
