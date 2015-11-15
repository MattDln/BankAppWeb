package ch.hearc.ig.odi.clientscomptes.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DeillonM
 */
public class Bank {

    private Integer number;
    private String name;
    private List<Account> accounts;
    private List<Customer> customers;

    public Bank(Integer pnumber, String pname) {
        this.number = pnumber;
        this.name = pname;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public Account getAccountByNumber(Integer pnumber) {
        return accounts.get(pnumber);
    }

    public Customer getCustomerByNumber(Integer pnumber) {
        return customers.get(pnumber);
    }

    public Customer addCustomer(Integer pnumber, String pFirstName, String pLastName) {
        Customer newCustomer = new Customer(pnumber,pFirstName, pLastName);
        customers.add(newCustomer);
        return newCustomer;
    }

    public void addAccount(String pnumber, String pname, Double prate, Customer pcustomer) {
        Account newAccount = new Account(pnumber, pname, 0.0, prate, pcustomer);
        pcustomer.addAccount(newAccount);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
