/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.presentation.bean;

import ch.hearc.ig.odi.clientscomptes.business.Customer;
import ch.hearc.ig.odi.clientscomptes.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author DeillonM
 */

@Named
@RequestScoped
public class ListCustomerBean implements Serializable{
    
    @Inject Services services;

    public ListCustomerBean() {
    }
    
    public List<Customer> getCustomers() {
        return services.getCustomersList();
    }
    public String ajouter(){
        Customer customer = new Customer();
        services.setCustomer(customer);
        return "add";                
    }
}
