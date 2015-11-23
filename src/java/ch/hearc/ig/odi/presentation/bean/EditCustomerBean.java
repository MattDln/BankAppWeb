/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.presentation.bean;

import ch.hearc.ig.odi.clientscomptes.business.Customer;
import ch.hearc.ig.odi.clientscomptes.service.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DeillonM
 */

@Named
@RequestScoped
public class EditCustomerBean implements Serializable {
    
    @Inject Services services;
    Customer customer;

    /**
     *
     */
    public EditCustomerBean() {
    }

    
    public Customer getCustomer() {
        this.customer=services.getCustomer();
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        services.setCustomer(customer);
    }

    /**
     *
     * @return
     */
    public String send() {
        services.saveCustomer(customer);
        return "sent";
    }  
     
    /**
     *
     * @return
     */
    public String cancel() {
        return "cancel";
    }

}
