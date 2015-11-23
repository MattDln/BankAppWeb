/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.clientscomptes.service;

import ch.hearc.ig.odi.clientscomptes.business.Bank;
import ch.hearc.ig.odi.clientscomptes.business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Classe de services qui stocke les donn�es de l'application dans la session de l'utilisateur.
 * Cette classe est g�r�e par CDI et peut donc �tre inject�e dans les autres classes Java.
 * @author julien.plumez
 */
@SessionScoped
@Stateful
public class Services implements Serializable{
    
    private Bank bank;
    private Customer customer;
    
    /**
     *
     */
    public Services(){
        bank = new Bank(1, "Raiffeisen Neuch�tel");
        
        Customer cust = bank.addCustomer(1, "Jean", "Dupont");
        
        bank.addAccount("1", "Salaire", 0.001, cust);
        bank.addAccount("2", "Impots", 0.002, cust);
        
        cust = bank.addCustomer(2, "Marie", "Dupont");
        bank.addAccount("3", "Epargne", 0.002, cust);
        bank.addAccount("4", "Salaire", 0.001, cust);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Dit � la banque de cr�er un nouveau client.
     * @param number Le num�ro unique du client
     * @param fn Le pr�nom du client
     * @param ln Le nom du client
     */
    public void saveCustomer(Integer number, String fn, String ln){
        bank.addCustomer(number, fn, ln);
    }

    public void saveCustomer(Customer cust){
        bank.addCustomer(cust);
    }    
    
    /**
     * Retourne le client de la banque qui correspond au num�ro pass� en param�tre.
     * @param number Le num�ro du client � rechercher
     * @return Le client, ou null s'il n'est pas trouv�
     */
    public Customer getCustomer(Integer number){
        return bank.getCustomerByNumber(number);
    }
    
    /**
     * Retourne une Map contenant tous les clients de la banque
     * @return Une Map contenant tous les clients de la banque
     */
    public List<Customer> getCustomers(){
        return bank.getCustomers();
    }
    
    /**
     * Retourne une List contenant tous les clients de la banque.
     * Utile pour l'affichage des clients dans les facelets
     * @return Une List contenant tous les clients de la banque.
     */
    public List<Customer> getCustomersList(){
        return new ArrayList(getCustomers());
    }
    
    
}
