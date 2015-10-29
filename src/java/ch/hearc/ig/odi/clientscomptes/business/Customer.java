/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.clientscomptes.business;

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

    public Customer(Integer number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* Easy mode
     public Account getAccountByNumber(Integer number) {
     return accounts.get(number);
     }*/
    
    public Account getAccountByNumber(Integer number) {
        Account accToReturn = null;
        for (Account currentAcc : accounts) {
            if (currentAcc.getNumber().equals(number)) {
                accToReturn = currentAcc;
            }
        }
        return accToReturn;
    }

    public void addAccount(String number, String name, Double balance, Double rate) {
        Account account = new Account(number, name, balance, rate, this);
        boolean isPresent = false;
        for (Account acc : accounts) {
            isPresent = isPresent && acc.equals(account);
        }
        if (isPresent) {
            throw new IllegalArgumentException();
        } else {
            accounts.add(account);
        }
    }

}
