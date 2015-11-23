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

    /**
     *
     * @param number
     * @param Name
     * @param lastName
     */
    public Customer(Integer number, String Name, String lastName) {
        this.number = number;
        this.firstName = Name;
        this.lastName = lastName;
        this.accounts=new ArrayList<>();
    }

    /**
     *
     */
    public Customer() {
    }
        
    /**
     *
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     *
     * @return
     */
    public String getLastName() {
        return this.lastName;        
    }
    
    /**
     *
     * @return
     */
    public Integer getNumber() {
        return number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @param accounts
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    /**
     *
     * @param number
     * @return
     */
    public Account getAccountByNumber(Integer number) {
        Account accToReturn = null;
        for (Account currentAcc : accounts) {
            if (currentAcc.getNumber().equals(number)) {
                accToReturn = currentAcc;
            }
        }
        return accToReturn;
    }

    /**
     *
     * @param paccount
     */
    public void addAccount(Account paccount) {
        accounts.add(paccount);
    }
    
    /**
     *
     * @param number
     * @param name
     * @param balance
     * @param rate
     */
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