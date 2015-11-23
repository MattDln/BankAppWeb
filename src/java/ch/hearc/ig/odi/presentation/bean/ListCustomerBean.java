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
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
    
    private  DataModel<Customer> customers;

    public ListCustomerBean() {
    }
    
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
        customers.setWrappedData(services.getCustomers());
        return customers;
    }

    public void setCustomers(DataModel<Customer> customers) {
        this.customers = customers;
    }    
    
    public String ajouter(){
        Customer customer = new Customer();
        services.setCustomer(customer);
        return "add";                
    }
    
   public String editer(){
       Customer customer = customers.getRowData();
       services.setCustomer(customer);
       return "edit";
   }
}
