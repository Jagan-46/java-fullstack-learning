package com.example.Student;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;
import org.slf4j.*;
@RestController
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/api/students")
    public String addStudent(@Valid @RequestBody Student student){
        logger.info("Student add request Recived");
      try{
          students.add(student);
          logger.info("Student added: "+student.getName());
          return "Student Added";
      }
        catch(Exception e){
          logger.error("Error adding student: "+e.getMessage());
          return "Error: "+e.getMessage();
        }
    }
    @GetMapping("/api/students")
    public ArrayList<Student> getAllStudents(){
        return students;
    }

    @PutMapping("/api/students/{id}")
    public String updateStudent(@PathVariable int id,@Valid @RequestBody Student student){
        try{
            for(Student s: students){
                if(s.getId()==id){
                    s.setName(student.getName());
                    s.setMarks(student.getMarks());
                    logger.info("Student updated: "+s.getName()+" "+s.getMarks());
                    return "Student Updated";
                }
            }
            return "Student not found";
            }
        catch(Exception e){
            logger.error("Error in Updating Student: "+ e.getMessage());
            return "Error "+e.getMessage();
        }

    }
    @DeleteMapping("/api/students/{id}")
    public String deleteStudent(@PathVariable int id){
        for(Student s: students){
            if(s.getId()==id){
                students.remove(s);
                logger.info("Student Deleted: "+s.getName());
                return "Student Deleted";
            }
        }
        return "Student Not Found";
    }
    @GetMapping("/api/students/search")
    public ArrayList<Student> searchByStudents(@RequestParam String name){
        ArrayList<Student> results = new ArrayList<>();
        for(Student s: students){
            if(s.getName().equals(name)){
                results.add(s);
                logger.info("Student added");
            }
        }
        return results;
    }
    @GetMapping("/api/students/filter")
    public ArrayList<Student> filterStudents(@RequestParam int minMarks,@RequestParam int maxMarks){
        ArrayList<Student> results = new ArrayList<>();
        for(Student s: students){
            if(s.getMarks()>=minMarks && s.getMarks() <= maxMarks){
                results.add(s);
                logger.info("Student with marks between marks: "+ results);
            }
        }
        return results;
    }
}
