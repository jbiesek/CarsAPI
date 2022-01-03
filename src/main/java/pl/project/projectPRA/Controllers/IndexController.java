package pl.project.projectPRA.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.projectPRA.Entities.*;
import pl.project.projectPRA.Services.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;



@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PersonService personService;

    @Autowired
    private DealerService dealerService;

    @Autowired
    private CarService carService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping(value = "")
    String index() {
        return "hello";
    }


    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        Person p0 = new Person("00282411111","Jędrzej", "Biesek");
        Person p1 = new Person("99271322222","Jan", "Kowalski");
        Person p2 = new Person("88232522222","Adam", "Nowak");
        Person p3 = new Person("83241188888","Anna", "Malinowska");
        Person p4 = new Person("78010123654","Ryszard", "Andrzejewski");
        Person p5 = new Person("64121154698","Beata", "Wałdoch");
        Person p6 = new Person("01252356987","Mikołaj", "Gajos");
        Person p7 = new Person("92071432165","Agata", "Szczepańska");

        Company cp0 = new Company("5551234769", "RWdew", "Piękna 33", "Poznań", p0);
        Company cp1 = new Company("6661235498", "Januszexpol", "Brzydka 34", "Poznań", p1);
        Company cp2 = new Company("2225697412", "Korpopol", "Malarska 2", "Poznań", p5);


        Dealer d0 = new Dealer("BMW Szczepańska", "Górczewska 3", "Poznań", p7);
        Dealer d1 = new Dealer("Peugeot Nowak", "Wysoka 42", "Poznań", p2);
        Dealer d2 = new Dealer("Nissan Gajos", "Marszałkowska 34", "Warszawa", p6);
        Dealer d3 = new Dealer("BMW Andrzejewski", "Szeroka 3", "Warszawa", p4);

        Car c0 = new Car("WBAVB175X6NK24697", "BMW", "750i", 1995, d0);
        Car c1 = new Car("1FMCU9EG9CKC99312", "BMW", "530d", 2008, d0);
        Car c2 = new Car("1GTGK23U54F130894", "BMW", "116i", 2020, d0);
        Car c3 = new Car("1N4BL2AP0BN596150","BMW", "840i", 2018, d0);
        Car c4 = new Car("1GNCS13W7V2148338", "BMW", "M5", 2015, d0);
        Car c5 = new Car("2G1WF52E649466695", "BMW", "318d", 2020, d0);
        Car c6 = new Car("2FTRX18W5XCA02590", "BMW", "328i", 2002, d0);
        Car c7 = new Car("1HGCM72606A067164", "BMW", "850CSi", 1999, d0);
        Car c8 = new Car("4T3ZA3BB2EU086533", "Peugeot", "407", 2008, d1);
        Car c9 = new Car("YV1612TKXF1305292", "Peugeot", "508", 2012, d1);
        Car c10 = new Car("1G4AH19R1GD428324", "Peugeot", "208", 2019, d1);
        Car c11 = new Car("4A3AB56F96E012308", "Peugeot", "5008", 2020, d1);
        Car c12 = new Car("WAUDK78T28A028811", "Peugeot", "307", 2003, d1);
        Car c13 = new Car("KNALN4D77E5154726", "Peugeot", "207", 2009, d1);
        Car c14 = new Car("1GBJG31U971288256", "Nissan", "Qashqai", 2014, d2);
        Car c15 = new Car("1N4AL21E69N441624", "Nissan", "Patrol", 1998, d2);
        Car c16 = new Car("3GCPCREC5EG550410", "Nissan", "Qashqai",2013,d2);
        Car c17 = new Car("JM1BL1SF2A1233543", "Nissan", "Pulsar", 2021, d2);
        Car c18 = new Car("1G3NB52M8X6314113", "Nissan", "370Z", 2012, d2);
        Car c19 = new Car("JTKJF5C74E3037771", "Nissan", "Primera", 1996, d2);
        Car c20 = new Car("1GDGG31V031905712", "BMW", "420d",2017,d3);
        Car c21 = new Car("4JGBF71E27A120148", "BMW", "640i", 2008, d3);
        Car c22 = new Car("SHSRD78596U437860", "BMW", "740d", 2013, d3);


        ZoneId zoneId = ZoneId.of("UTC+1");
        ZonedDateTime date  = ZonedDateTime.of(2015, 11, 30, 23, 45, 0, 0, zoneId);
        Transaction t0 = new Transaction(date, c0,p0);
        date  = ZonedDateTime.of(2019, 3, 20, 13, 12, 0, 0, zoneId);
        Transaction t1 = new Transaction(date,c1,p2);
        date  = ZonedDateTime.of(2021, 2, 12, 11, 20, 0, 0, zoneId);
        Transaction t2 = new Transaction(date,c2,p3);
        date  = ZonedDateTime.of(2018, 5, 5, 9, 30, 0, 0, zoneId);
        Transaction t3 = new Transaction(date,c3,p4);
        date  = ZonedDateTime.of(2015, 10, 22, 12, 38, 0, 0, zoneId);
        Transaction t4 = new Transaction(date,c4,p5);
        date  = ZonedDateTime.of(2021, 1, 18, 13, 0, 0, 0, zoneId);
        Transaction t5 = new Transaction(date,c5,p6);
        date  = ZonedDateTime.of(2002, 12, 7, 8, 33, 0, 0, zoneId);
        Transaction t6 = new Transaction(date,c6,p7);
        date  = ZonedDateTime.of(2021, 8, 1, 18, 0, 0, 0, zoneId);
        Transaction t7 = new Transaction(date,c8,p0);
        date  = ZonedDateTime.of(2013, 3, 29, 10, 27, 0, 0, zoneId);
        Transaction t8 = new Transaction(date,c9,p3);
        date  = ZonedDateTime.of(2019, 6, 26, 14, 9, 0, 0, zoneId);
        Transaction t9 = new Transaction(date,c10,p6);
        date  = ZonedDateTime.of(2009, 8, 24, 12, 48, 0, 0, zoneId);
        Transaction t10 = new Transaction(date,c13,p2);
        date  = ZonedDateTime.of(2013, 4, 14, 15, 12, 0, 0, zoneId);
        Transaction t11 = new Transaction(date,c16,p5);
        date  = ZonedDateTime.of(2012, 7, 17, 13, 30, 0, 0, zoneId);
        Transaction t12 = new Transaction(date,c18,p0);
        date  = ZonedDateTime.of(2010, 9, 14, 10, 33, 0, 0, zoneId);
        Transaction t13 = new Transaction(date,c19,p0);
        date  = ZonedDateTime.of(2008, 8, 24, 12, 2, 0, 0, zoneId);
        Transaction t14 = new Transaction(date,c21,p4);

        personService.savePerson(p0);
        personService.savePerson(p1);
        personService.savePerson(p2);
        personService.savePerson(p3);
        personService.savePerson(p4);
        personService.savePerson(p5);
        personService.savePerson(p6);
        personService.savePerson(p7);

        companyService.saveCompany(cp0);
        companyService.saveCompany(cp1);
        companyService.saveCompany(cp2);


        dealerService.saveDealer(d0);
        dealerService.saveDealer(d1);
        dealerService.saveDealer(d2);
        dealerService.saveDealer(d3);


        carService.saveCar(c0);
        carService.saveCar(c1);
        carService.saveCar(c2);
        carService.saveCar(c3);
        carService.saveCar(c4);
        carService.saveCar(c5);
        carService.saveCar(c6);
        carService.saveCar(c7);
        carService.saveCar(c8);
        carService.saveCar(c9);
        carService.saveCar(c10);
        carService.saveCar(c11);
        carService.saveCar(c12);
        carService.saveCar(c13);
        carService.saveCar(c14);
        carService.saveCar(c15);
        carService.saveCar(c16);
        carService.saveCar(c17);
        carService.saveCar(c18);
        carService.saveCar(c19);
        carService.saveCar(c20);
        carService.saveCar(c21);
        carService.saveCar(c22);


        transactionService.saveTransaction(t0);
        transactionService.saveTransaction(t1);
        transactionService.saveTransaction(t2);
        transactionService.saveTransaction(t3);
        transactionService.saveTransaction(t4);
        transactionService.saveTransaction(t5);
        transactionService.saveTransaction(t6);
        transactionService.saveTransaction(t7);
        transactionService.saveTransaction(t8);
        transactionService.saveTransaction(t9);
        transactionService.saveTransaction(t10);
        transactionService.saveTransaction(t11);
        transactionService.saveTransaction(t12);
        transactionService.saveTransaction(t13);
        transactionService.saveTransaction(t14);


        return "Model Generated";
    }
}
