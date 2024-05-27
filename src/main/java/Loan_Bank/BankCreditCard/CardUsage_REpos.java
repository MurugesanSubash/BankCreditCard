package Loan_Bank.BankCreditCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CardUsage_REpos extends JpaRepository<CardUsage_Entity , Long> {
    
}
