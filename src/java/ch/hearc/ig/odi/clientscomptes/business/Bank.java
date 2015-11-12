package ch.hearc.ig.odi.clientscomptes.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Account getAccountByNumber(Integer pnumber) {
        return accounts.get(pnumber);
    }

    public Customer getCustomerByNumber(Integer pnumber) {
        return customers.get(pnumber);
    }

    public Customer addCustomer(Integer pnumber, String pFirstName, String pLastName) {
        Customer newCustomer = new Customer(number, pFirstName, pFirstName);
        boolean isPresent = false;
        for (Customer curentCustomer : customers) {
            isPresent = isPresent && curentCustomer.equals(newCustomer);
        }
        if (isPresent) {
            throw new IllegalArgumentException();
        } else {
            customers.add(newCustomer);
        }
        return newCustomer;
    }

    public void addAccount(String pnumber, String pname, Double prate, Customer pcustomer) {
        Account newAccount = new Account(pnumber, pname, null, prate, pcustomer);
        boolean isPresent = false;
        for (Account curentAccount : accounts) {
            isPresent = isPresent && curentAccount.equals(newAccount);
        }
        if (isPresent) {
            throw new IllegalArgumentException();
        } else {
            accounts.add(newAccount);
        }
    }

    public Map<Integer, Customer> getCustomers() {
        Map<Integer, Customer> mCustomer = new HashMap();
        for (Customer cust : customers) {
            Integer num = cust.getNumber();
            mCustomer.put(num, cust);
        }
        return mCustomer;
    }
}
