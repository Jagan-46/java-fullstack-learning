public class Student {
    String name;
    int age;
    int rollnumber;
    double gpa;
    public Student(String name, int age, int rollnumber, double gpa){
        this.name=name;
        this.age=age;
        this.rollnumber=rollnumber;
        this.gpa=gpa;
    }
    public void displayInfo(){
        System.out.println("name: "+name+" age: "+ age+" rollnumber: "+ rollnumber+ " gpa: "+gpa);
    }
    public boolean isEligibleForScholarship(){
        return gpa >= 3.5;
    }
    public static void main(String [] args) {
        //First Student-
        Student student1 = new Student("Jagan", 21, 23, 9.9);
        student1.displayInfo();
        System.out.println("IS ELIGIBLE FOR SCHOLARSHIP: "+student1.isEligibleForScholarship());
        //Second Student--
         Student student2 = new Student("siva",23,54,8.9);
         student2.displayInfo();
         System.out.println("IS ELIGIBLE FOR SCHOLARSHIP: "+ student2.isEligibleForScholarship());
         //Third Student---
        Student student3 = new Student("ArunKumar",23,03,2.5);
        student3.displayInfo();
        System.out.println("IS ELIGIBLE FOR SCHOLARSHIP: "+ student3.isEligibleForScholarship());
    }
}