interface Employee{
    double calculateSalary();
    void getDetails();
}
public abstract class Person{
    String name;
    int age;
    public abstract void work();
}
class Manager extends Person implements Employee{
    String department;
    public Manager(String name,int age,String department){
        this.name=name;
        this.age=age;
        this.department=department;
    }
    public double calculateSalary(){
        if(department.equals("IT")){
            return 120000;
        }
        else if (department.equals("HR")){
            return 125000;
        }
        return 0;
    }
    public void getDetails(){
System.out.println(name+" "+age+" "+department);
    }
    public void work(){
      System.out.println("work Description");
    }
    public static void main(String[]args){
        Manager manager1 = new Manager("jagan",21,"IT");
        Manager manager2 = new Manager("Siva",23,"HR");
          Employee[] employee = {manager1,manager2};
          for(Employee emp : employee){
              System.out.println("Salary: "+emp.calculateSalary());
              emp.getDetails();
          }
          manager1.work();
          manager2.work();
    }
}