package com.example.Student;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name="teacher")
public class Teacher {
@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
@Column(name="name",nullable=false)
    private String name;
@OneToMany(mappedBy="teacher",cascade =CascadeType.ALL)
    private List<Student> students;
public Teacher(){

}
public Teacher(String name){
    this.name=name;
}
public int getId(){
    return id;
}
public String getName(){
    return name;
}
public List<Student> getStudents(){
    return students;
}
public void setId(int id){
    this.id=id;
}
public void setName(String name){
    this.name=name;
}
public void setStudents(List<Student> students){
    this.students=students;
}
}
