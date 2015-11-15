/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.presentation.bean;

import ch.hearc.ig.odi.clientscomptes.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */
@Named
@RequestScoped
public class EditCustomerBean implements Serializable {

    private Customer customer;

    public EditCustomerBean() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String cancel() {
        return "cancel";
    }

}
