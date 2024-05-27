package Loan_Bank.BankCreditCard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creditcard")
public class Credit_Card_Controller {

    @Autowired
    Credit_Card_Service Service_obj;

    @PostMapping("/addnew")
    public String newCardCustomer(@RequestBody Credit_card_Entity customerDetails){

        return Service_obj.addNewCustomer(customerDetails).getCustomerName() + " has added successfully";
    }

    @GetMapping("/viewall")
    public List< Credit_card_Entity> showAllCustomer(){
        return Service_obj.showListofCustomer();
    }

    @GetMapping("/findbyaccount/{accnum}")
    public Optional<Credit_card_Entity> findByAccountNumber(@PathVariable ("accnum") Long accnum){

        return Service_obj.findByAccountNumber(accnum);
    }

    @PutMapping("/update")
    public String updateAccountDetails(@RequestBody Credit_card_Entity accountDetails){
       Credit_card_Entity detailsSave = Service_obj.addNewCustomer(accountDetails);
        return detailsSave.getCustomerName() + " has been updated ";
    }
    
    @DeleteMapping("/delete/{accdet}")
    public String deleteAccountDetails(@PathVariable ("accdet") Long accdet){

        return Service_obj.deleteAccount(accdet);
    }

    @GetMapping("/findbycardtype/{type}")
    public List<Credit_card_Entity> findByCardType(@PathVariable ("type") String type){

        return Service_obj.findAllByCardType(type);
    }

    @Autowired
    CardUsage_Service C_Servi_obj;

    @PostMapping("/addtranslation")
    public String  addTransla(@RequestBody CardUsage_Entity translaDetails){

        translaDetails.setBalanceMoney(translaDetails.getCusDetails().getCardLimit());

        return C_Servi_obj.addTrans(translaDetails) +" translation success";
    }
}
