package Loan_Bank.BankCreditCard;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CardCustomerDetails")
public class Credit_card_Entity {
@Id
private Long  creditCardNumber;
private String customerName;
private String cardExpiryDate;
private String creditCardType;
private String customerAddharNumber;
private String customerPanNumber;
private Long cardLimit;
    
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JsonManagedReference
@JoinTable(name="Connection" , joinColumns = @JoinColumn(name="CardNumber"),inverseJoinColumns = @JoinColumn(name="translationID"))
private List <CardUsage_Entity> translList = new ArrayList<>();
}