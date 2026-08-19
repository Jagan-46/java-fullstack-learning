package com.example.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
public class Controller {
    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/api/student")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfuly";
    }

    @GetMapping("/api/student")
    public ArrayList<Student> getAllStudent() {
        return students;
    }

    @PutMapping("/api/student/{id}")
    public Student updateMarks(@PathVariable int id,@RequestBody Student student) {
        for(Student s : students){
            if(s.getId()==id){
                s.setName(student.getName());
                s.setMarks(student.getMarks());
                return s;
            }
        }
        return null;

    }
    @DeleteMapping("/api/student/{id}")
    public String deleteStudent(@PathVariable int id){
        for(Student s : students){
            if(s.getId()==id){
                students.remove(s);
                return "Student Removed Successfuly";
             }
        }
        return null;
    }
}
