/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import com.mycompany.classes.Student;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author Guest
 */
@Named
@ApplicationScoped
public class StudentService {

    List<Student> students;

    /**
     * Creates a new instance of StudentService
     */
    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Marek", "Smorąg", 3.0));
        students.add(new Student("Bartosz", "Rudecki", 4.54));
        students.add(new Student("Jakub", "Dąbała", 5.43));
        students.add(new Student("Jakub", "Rek", 4.23));
        students.add(new Student("Julia", "Smorąg", 3.56));
        students.add(new Student("Arkadiusz", "Abramowski", 3.56));
        students.add(new Student("Marta", "Nowak", 4.23));
        students.add(new Student("Rafał", "Zalewski", 4.67));
        students.add(new Student("Adrian", "Zalewski", 5.0));
        students.add(new Student("Mirosław", "Kulesza", 4.12));
        students.add(new Student("Michał", "Kostro", 3.67));
        students.add(new Student("Jan", "Nowak", 3.38));
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

}
