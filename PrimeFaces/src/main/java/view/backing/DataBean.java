/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import com.mycompany.classes.Student;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Guest
 */
@Named(value = "dataBean")
@ViewScoped
public class DataBean implements Serializable{
   

    /**
     * Creates a new instance of DataBean
     */
    private List<Student> students;
    
    @Inject
    private StudentService service;
    
    @PostConstruct
    public void init(){
        students = service.getStudents();
    }
    
    public List<Student> getStudents(){
        return students;
    }
    
    public void setService(StudentService service){
        this.service = service;
    }
    
}
