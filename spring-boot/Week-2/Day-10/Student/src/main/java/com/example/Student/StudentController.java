package com.example.Student;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;
import org.slf4j.*;
@RestController
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/api/students")
    public String addStudent(@Valid @RequestBody Student student){
        logger.info("Student add request Recived");
        try{
            studentRepository.save(student);
            logger.info("Student added: "+student.getName());
            return "Student Added";
        }
        catch(Exception e){
            logger.error("Error adding student: "+e.getMessage());
            return "Error: "+e.getMessage();
        }
    }
    @GetMapping("/api/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PutMapping("/api/students/{id}")
    public String updateStudent(@PathVariable int id,@Valid @RequestBody Student student){
        try{
            Student s = studentRepository.findById(id).orElse(null);
                if(s!=null){
                    s.setName(student.getName());
                    s.setMarks(student.getMarks());
                    studentRepository.save(s);
                    logger.info("Student updated: "+s.getName());
                    return "Student Updated";
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
            if(studentRepository.existsById(id)){
                studentRepository.deleteById(id);
                logger.info("Student Deleted: "+id);
                return "Student Deleted";
            }

        return "Student Not Found";
    }
    @GetMapping("/api/students/searchByName")
    public List<Student> searchByStudents(@RequestParam String name){
        logger.info("Search Request For name "+ name);
        return studentRepository.findByName(name);
        }
    @GetMapping("/api/students/searchById")
    public Student searchById(@RequestParam int id) {
        logger.info("Search Request fro Id " + id);
        return studentRepository.findById(id).orElse(null);
    }
    @GetMapping("/api/students/findByNameAndMarks")
    public List<Student> findByNameAndMarks(@RequestParam String name, @RequestParam int marks){
        logger.info("Search by name and marks"+name +" "+marks);
        return studentRepository.findByNameAndMarks(name,marks);
    }
    @GetMapping("/api/students/findByMarksGreaterThan")
    public List<Student> findByMarksGreaterThan(@RequestParam int marks){
        logger.info("Student by marks greater marks: "+ marks);
        return studentRepository.findByMarksGreaterThan(marks);
    }
    @GetMapping("/api/students/findByMarksLessThan")
    public List<Student> findByMarksLessThan(@RequestParam int marks){
        logger.info("Student marks less than: "+ marks);
        return studentRepository.findByMarksLessThan(marks);
    }
    @GetMapping("/api/students/findByMarksBetween")
    public List<Student> findByMarksBetween(@RequestParam int minMarks,@RequestParam int maxMarks){
        logger.info("Students marks between: "+minMarks+" "+maxMarks);
        return studentRepository.findByMarksBetween(minMarks,maxMarks);
    }
    @GetMapping("/api/students/countByName")
    public long countByName(@RequestParam String name){
        logger.info("count by student name: "+name);
        return studentRepository.countByName(name);
    }
    @Autowired
    StudentService studentService;
    @PutMapping("/api/students/{studentId}/transfer/{teacherId}")
    public String transferStudent(@PathVariable int studentId,@PathVariable int teacherId){
        logger.info("Student Request :student "+studentId+"to teacher "+teacherId);
        return studentService.transferStudent(studentId,teacherId);
    }
    @PostMapping("/api/students/withTeacher")
    public String addStudentswithTeacher(@RequestBody Student student,@RequestParam int teacher_id){
        logger.info("Add Student With Teacher Request");
        return studentService.addStudentWithTeacher(student,teacher_id);
    }
}