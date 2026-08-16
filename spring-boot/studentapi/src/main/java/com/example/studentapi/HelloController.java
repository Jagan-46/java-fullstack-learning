package com.example.studentapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class HelloController {
   @GetMapping("/api/hello")
   public String sayHello(){
       return "Hello SpringBoot";
   }
   @GetMapping("/api/students/{id}")
    public String getStudent(@PathVariable int id){
       return "Student with ID: "+id;
   }
   @GetMapping("/api/add")
    public String add(){
       return "added";
   }

}

