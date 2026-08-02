import java.util.*;
public class Student {
    int studentId;
    String name;
    public Student(int studentId,String name){
        this.studentId=studentId;
        this.name=name;
    }
    public void getDetails(){
        System.out.println(studentId+" "+name);
    }
    @Override
    public int hashCode(){
        return studentId;
    }
    @Override
    public boolean equals(Object obj){
        if (this ==obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId == student.studentId;
    }
    public static void main(String [] args){
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(23,"jagan"));
        students.add(new Student (17,"Gopi"));
        students.add(new Student(23,"jagan"));
        for(Student student:students){
            student.getDetails();
        }
    }
}
