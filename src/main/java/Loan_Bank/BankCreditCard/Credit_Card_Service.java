package Loan_Bank.BankCreditCard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Credit_Card_Service implements UserDetailsService {

    @Autowired
    Credit_Card_Repos Repos_Obj;

    public Credit_card_Entity addNewCustomer(Credit_card_Entity customerDetails){
        
        return Repos_Obj.save(customerDetails);
    }

    public List<Credit_card_Entity> showListofCustomer(){
        return Repos_Obj.findAll();
    }

    public Optional<Credit_card_Entity> findByAccountNumber(Long accountNumber){

        return Repos_Obj.findById(accountNumber);
    }

    public String deleteAccount(Long accountNumber ){
        Credit_card_Entity customer = Repos_Obj.findById(accountNumber).orElse(new Credit_card_Entity());
        Repos_Obj.deleteById(accountNumber);
        return customer.getCustomerName() + " has deleted successfully";
    }

    public List<Credit_card_Entity> findAllByCardType(String type){

        return Repos_Obj.findByCreditCardType(type);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Credit_card_Entity user = Repos_Obj.findByCustomerName(username);
    if(user==null){
        throw new UsernameNotFoundException(username);
    }
    return user;
    }
}
