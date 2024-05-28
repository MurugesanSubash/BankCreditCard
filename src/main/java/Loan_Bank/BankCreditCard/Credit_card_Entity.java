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
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CardCustomerDetails")
public class Credit_card_Entity implements UserDetails {
@Id
private Long  creditCardNumber;
private String customerName;
private String cardExpiryDate;
private String creditCardType;
private String customerAddharNumber;
private String customerPanNumber;
private Long cardLimit;
private String password;
    
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JsonManagedReference
// @JoinTable(name="Connection" , joinColumns = @JoinColumn(name="creditCardNumber"),inverseJoinColumns = @JoinColumn(name="translationID"))
private List <CardUsage_Entity> translList = new ArrayList<>();

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
     return null;
}

@Override
public String getUsername() {
return customerName;}

public String getPassword(){
    return password;
}

@Override
public boolean isAccountNonExpired() {
   return true;
}

@Override
public boolean isAccountNonLocked() {
    return true;}

@Override
public boolean isCredentialsNonExpired() {
    return true;}

@Override
public boolean isEnabled() {
    return true;}
}