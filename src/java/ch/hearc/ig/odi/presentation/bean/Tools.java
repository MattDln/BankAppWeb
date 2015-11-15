/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.presentation.bean;

import javax.faces.context.FacesContext;

/**
 *
 * @author DeillonM
 */
public class Tools {
    private static Tools instance;
    private Tools(){}
    
    public static Tools getInstance(){
        if(instance == null){ 
            instance = new Tools();
        }
        return instance;
    }
    
    public <T> T findBean(String ManagedBean, Class<T> beanClass){
        FacesContext context = FacesContext.getCurrentInstance();
        return beanClass.cast(context.getApplication().
                evaluateExpressionGet(context, "#{" + ManagedBean + "}", beanClass));
    }
}
