package com.example.Student;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;
import java.util.*;
@RestController
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/api/students")
    public String addStudent(@Valid @RequestBody Student student) {
        try{
            students.add(student);
            return "Added";
        }
        catch(Exception e){
            return   "Error: "+e.getMessage();
        }
    }

    @GetMapping("/api/students")
    public ArrayList<Student> getAllStudent() {
        return students;
    }

    @PutMapping("/api/students/{id}")
    public String updateStudents(@PathVariable int id,@Valid @RequestBody Student student) {
        try{
            for (Student s : students) {
                if (s.getId() == id) {
                    s.setName(student.getName());
                    s.setMarks(student.getMarks());
                    return "Updated";
                }
            }
            return "Student Not Found";
        }
        catch(Exception e){
            return "Error: "+e.getMessage();
        }
    }

    @DeleteMapping("/api/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                return "Deleted Successfuly";
            }
        }
        return "null";
    }
    @GetMapping("/api/students/search")
    public ArrayList<Student> searchByName(@RequestParam String name){
        ArrayList<Student> result = new ArrayList<>();
        for(Student s : students) {
            if (s.getName().equals(name)) {
                result.add(s);
            }
        }
        return result;
    }
    @GetMapping("/api/students/filter")
    public ArrayList<Student> filterStudent(@RequestParam int minMarks, @RequestParam int maxMarks){
        ArrayList<Student> result = new ArrayList<>();
        for(Student s : students) {
            if (s.getMarks() >= minMarks && s.getMarks() <= maxMarks) {
                result.add(s);
            }
        }
        return result;
    }
}