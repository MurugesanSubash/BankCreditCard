package Loan_Bank.BankCreditCard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Credit_Card_Repos extends JpaRepository <Credit_card_Entity, Long> {

    public List<Credit_card_Entity> findByCreditCardType(String place);

} 