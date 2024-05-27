package Loan_Bank.BankCreditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardUsage_Service {

    @Autowired
    CardUsage_REpos C_Repo_obj;
     
    public CardUsage_Entity addTrans(CardUsage_Entity translDetails){

        return C_Repo_obj.save(translDetails);
    }
    
}
