package com.example.Student;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
@RestController
public class TeacherController {
    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TeacherService teacherService;
    @PostMapping("/api/teachers")
    public String addTeacher(@RequestBody Teacher teacher){
        logger.info("Add Teacher Request "+teacher.getName());
       try{
           teacherRepository.save(teacher);
           logger.info("Teacher Added: "+teacher.getName());
           return "Teacher Added";
        }
       catch(Exception e){
           logger.error(e.getMessage());
           return e.getMessage();
       }
    }
    @DeleteMapping("/api/teachers/{id}")
    public String deleteTeacherById(@PathVariable int id){
        try{
            teacherRepository.deleteById(id);
            logger.info("Teacher deleted: "+id);
            return "Teacher Deleted";
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
    @GetMapping("/api/teachers")
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }
    @GetMapping("/api/teachers/search")
    public Teacher getTeacherByName(@RequestParam String name){
        logger.info("Get Teacher: "+ name);
        return teacherRepository.findByName(name);
    }
    @GetMapping("/api/teachers/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        logger.info("Get teacher: "+id);
        return teacherService.getTeacherById(id);
    }
}