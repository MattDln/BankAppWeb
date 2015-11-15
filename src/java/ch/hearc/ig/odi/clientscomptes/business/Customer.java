package ch.hearc.ig.odi.clientscomptes.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DeillonM
 */
public class Customer {

    private Integer number;
    private String firstName;
    private String lastName;
    private List<Account> accounts;

    public Customer(Integer number, String Name, String lastName) {
        this.number = number;
        this.firstName = Name;
        this.lastName = lastName;
        this.accounts=new ArrayList<>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;        
    }
    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public Account getAccountByNumber(Integer number) {
        Account accToReturn = null;
        for (Account currentAcc : accounts) {
            if (currentAcc.getNumber().equals(number)) {
                accToReturn = currentAcc;
            }
        }
        return accToReturn;
    }

    public void addAccount(Account paccount) {
        accounts.add(paccount);
    }
    
    public void addAccount(String number, String name, Double balance, Double rate) {
        Account account = new Account(number, name, balance, rate, this);
        boolean isPresent = false;
        for (Account acc : accounts) {
            if(!isPresent){
                isPresent = acc.equals(account);
            }
        }
        if (isPresent) {
            throw new IllegalArgumentException();
        } else {
            accounts.add(account);
        }
    }

}