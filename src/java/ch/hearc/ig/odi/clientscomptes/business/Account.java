/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.clientscomptes.business;

/**
 *
 * @author DeillonM
 */
public class Account {

    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.001;
    private Customer customer;

    public Account(Customer pcustomer) {
        this.customer = pcustomer;
    }

    public Account(String pnumber, String pname, Double pbalance, Double prate, Customer pcustomer) {
        this.number = pnumber;
        this.name = pname;
        this.balance = pbalance;
        this.rate = prate;
        this.customer = pcustomer;
    }

    public String getNumber() {
        return number;
    }
        

    public void credit(Double pamount) {
        this.balance += pamount;
    }

    public void debit(Double pamount) {
        this.balance -= pamount;
    }

    public static void transfert(Double pamount, Account psource, Account ptarget) {
        psource.debit(pamount);
        ptarget.credit(pamount);
    }

}

