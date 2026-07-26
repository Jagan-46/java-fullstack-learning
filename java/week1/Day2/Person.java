public class Person {
    String name;
    int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void displayInfo(){
        System.out.println("Name: "+ name + " Age: " + age);
    }
}
class Employee extends Person{
    int employeeID;
    double salary;
    public Employee(String name,int age,int employeeID,double salary){
        super(name,age);
        this.employeeID=employeeID;
        this.salary=salary;
    }
    public void displayInfo(){
        System.out.println("Name: "+name + " Age: "+age + " EmployeeID: "+employeeID + " Salary: "+ salary);
    }
}
class Manager extends Employee{
    String department;
    public Manager(String name,int age,int employeeID,double salary,String department){
        super(name,age,employeeID,salary);
        this.department=department;
    }
    public void displayInfo(){
        System.out.println("Name: "+name+" Age: "+age+" EmployeeID: "+employeeID+" Salary: "+salary+" Department: "+department);
    }
    public static void main(String [] args){
        //Person
        Person person1= new Person("Kalai",21);
        person1.displayInfo();
        //Employee
        Employee employee1 = new Employee("Siva",23,100134,33541.34);
        employee1.displayInfo();
        //Manager
        Manager manager1 = new Manager("Gopinath",23,100420,45386.17,"Finance");
        manager1.displayInfo();
    }
}

