import java.util.*;
public class StudentParser {
    public static void main(String [] args){
        String student = "John,25,95";
        String[] parts = student.split(",");
        String name = parts[0];
        String age = parts[1];
        String marks = parts[2];
        System.out.println("Name:"+name+" Age:"+age+" Marks:"+marks);
    }
}
