package Loan_Bank.BankCreditCard;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="CardUsageDetails")
public class CardUsage_Entity {
    
    private String cardUsageDate;
    private String moneyUsed;
    private Long balanceMoney;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "AA")
    @SequenceGenerator(name = "AA",sequenceName = "BB", allocationSize = 1)
    private Long translationID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creditCardNumber", nullable = false)
    @JsonBackReference
    private Credit_card_Entity cusDetails; 
}
