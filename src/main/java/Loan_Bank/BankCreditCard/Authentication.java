package Loan_Bank.BankCreditCard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Authentication {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager Myuser(){
        UserDetails user1 = User.withUsername("Nivi").password(encoder().encode("Nivi123")).roles("manager").build();
        UserDetails user2 = User.withUsername("Subash").password(encoder().encode("Subash123")).roles("team lead").build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public SecurityFilterChain httpFilter(HttpSecurity hp) throws Exception{
        // hp.authorizeHttpRequests().anyRequest().authenticated();
        // hp.authorizeHttpRequests().anyRequest().permitAll();

        hp.authorizeHttpRequests()
        .requestMatchers("/creditcard/**").authenticated();
        hp.csrf().disable();
        hp.cors();
        hp.httpBasic();
        hp.formLogin();

        return hp.build(); 
    }    
}
