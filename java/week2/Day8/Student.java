import java.util.*;
class Student{
    int studentId;
    String name;
    int marks;
    public Student(int studentId,String name,int marks){
        this.studentId=studentId;
        this.name=name;
        this.marks=marks;
    }
    public void displayInfo(){
        System.out.println(name+" "+marks);
    }
    public static void main(String [] args){
     ArrayList<Student> students = new ArrayList<>();
     students.add(new Student(23,"Jagan",96));
     students.add(new Student (54,"Siva",98));
     students.add(new Student(76,"Teja",78));
     Collections.sort(students, new Comparator<Student>(){
         public int compare(Student s1, Student s2){
             return s2.marks - s1.marks;
         }
     });
     for(Student student : students){
         student.displayInfo();
     }
    }
}