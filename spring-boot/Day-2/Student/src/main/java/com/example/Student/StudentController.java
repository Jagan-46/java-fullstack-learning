package com.example.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
public class StudentController{
    ArrayList<Student> students = new ArrayList<>();
    @PostMapping("/api/students")
    public String addStudents(@RequestBody Student student){
        students.add(student);
        return "Student added successfuly";
    }
    @GetMapping("/api/students")
    public ArrayList<Student> getAllStudent(){
return students;
    }
}