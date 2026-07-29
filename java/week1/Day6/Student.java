import java.util.*;
public class Student {
    String name;
    int mark;
    public Student(String name,int mark){
        this.name = name;
        this.mark = mark;
    }
    public void displayInfo(){
        System.out.println("Name: "+name+" Marks: "+mark);
    }
    public static void main(String [] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jagan",99));
        students.add(new Student("Siva",98));
        students.add(new Student("Kalai",97));
        for(Student student : students){
            student.displayInfo();
        }
    }
}
