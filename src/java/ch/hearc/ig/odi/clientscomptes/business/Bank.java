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
public class Bank {

    private Integer number;
    private String name;
    private List<Customer> customers;
    private List<Account> accounts;
    
    public Bank(Integer pnumber, String pname) {
        this.number = pnumber;
        this.name = pname;
    }
    
    public Account getAccountByNumber (Integer pnumber) {
        return accounts.get(pnumber);
    }
    
    public Customer getCustomerByNumber(Integer pnumber) {
        return customers.get(pnumber);
    }    
    
    public void addCustomer (Integer pnumber, String pFirstName, String pLastName) {
        Customer newCustomer = new Customer(number, pFirstName, pFirstName);
        boolean isPresent = false;
        for (Customer curentCustomer : customers){
            isPresent = isPresent && curentCustomer.equals(newCustomer);
        }
         if (isPresent) {
            throw new IllegalArgumentException();
        } else {
            customers.add(newCustomer);
        }
    }    
}
