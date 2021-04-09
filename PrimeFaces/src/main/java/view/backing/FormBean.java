/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guest
 */
@Named(value = "formBean")
@RequestScoped
public class FormBean {

private int value1 = 0;
private int value2 = 0;
private int sum = 0;
private LocalDateTime date;
    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
        date = LocalDateTime.now();
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void sum(){
        String i = getValue1()+"+"+getValue2()+"="+(getValue1()+getValue2());
        setDate(LocalDateTime.now());
        setSum(getValue1()+getValue2());
        addMessage(FacesMessage.SEVERITY_INFO, "Sum", i);
    }

    /**
     * @return the value1
     */
    public int getValue1() {
        return value1;
    }

    /**
     * @param value1 the value1 to set
     */
    public void setValue1(int value1) {
        this.value1 = value1;
    }

    /**
     * @return the value2
     */
    public int getValue2() {
        return value2;
    }

    /**
     * @param value2 the value2 to set
     */
    public void setValue2(int value2) {
        this.value2 = value2;
    }

    /**
     * @return the sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
}
