package com.example.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name" ,nullable = false)
    @NotBlank
    private String name;
    @Column(name = "marks")
    @Min(0)
    @Max(100)
    private int marks;
    @ManyToOne
    @JoinColumn(name="teacher_id")
    @JsonIgnore
    private Teacher teacher;
    public Student(){

    }
    public Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }
    public void setTeacher(Teacher teacher){
        this.teacher=teacher;
    }
}
