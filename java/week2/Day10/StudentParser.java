import java.util.*;
public class StudentParser {
    String email;
    String password;
    String name;

    public StudentParser(String email,String password,String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public boolean validateEmail() {
        if(email.contains("@")){
            return true;
        }
        return false;
    }

    public boolean validatePassword() {
        if (password.length() >= 8){
            return true;
        }
        return false;
    }

    public boolean validateName() {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
     StudentParser emails = new StudentParser("jagan@gmail.com","abcd1234","Jagan1");
     System.out.println("Email valid: "+emails.validateEmail());
     System.out.println("Password Valid: "+emails.validatePassword());
     System.out.println("Name Valid: "+emails.validateName());
    }
}
