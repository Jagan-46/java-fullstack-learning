import java.util.*;
import java.io.*;
public class Student {
    String fileName;
    int id;
    String name;
    int marks;
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }
    @Override
    public String toString(){
        return id+","+name+","+marks;
    }
    public Student(int id,String name,int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
}
class studentManager {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void saveToFile(String fileName) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int marks = Integer.parseInt(parts[2]);
                Student student = new Student(id, name, marks);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student updateMarks(int id, int newMarks) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setMarks(newMarks);
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public void displayAll() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        studentManager manager = new studentManager();
        while (true) {
            System.out.println("1.Add Student");
            System.out.println("2.Search Student");
            System.out.println("3.Update Student Marks");
            System.out.println("4.Delete Student");
            System.out.println("5.display All Students");
            System.out.println("6.Save To File");
            System.out.println("7.Load From File");
            System.out.println("8.Exit");
            System.out.println("Enter Choice : ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter id,name,marks:");
                int id = scanner.nextInt();
                scanner.nextLine();
                String name = scanner.nextLine();
                int marks = scanner.nextInt();
                manager.addStudent(new Student(id, name, marks));
            } else if (choice == 2) {
                System.out.println("Enter Student ID:");
                int id = scanner.nextInt();
                Student student = manager.searchStudent(id);
                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("Student Not Found");
                }
            } else if (choice == 3) {
                System.out.println("Enter student Id , new Marks: ");
                int id = scanner.nextInt();
                int mark = scanner.nextInt();
                Student update = manager.updateMarks(id, mark);
                if (update != null) {
                    System.out.println("Updated : " + update);
                } else {
                    System.out.println("Student Not Found");
                }
            } else if (choice == 4) {
                System.out.println("Enter Student ID: ");
                int id = scanner.nextInt();
                boolean deleted = manager.deleteStudent(id);
                if (deleted) {
                    System.out.println("Deleted");
                } else {
                    System.out.println("Student Not Found");
                }
            } else if (choice == 5) {
                manager.displayAll();
            } else if (choice == 6) {
                System.out.println("Enter FileName:");
                String fileName = scanner.nextLine();
                try {
                    manager.saveToFile(fileName);
                    System.out.println("Students Added To File");
                } catch (IOException e) {
                    System.out.println("Error:" + e.getMessage());
                }
            } else if (choice == 7) {
              System.out.println("Enter File Name:");
              String fileName = scanner.nextLine();
             try {
                 manager.loadFromFile(fileName);
                 System.out.println("Loaded From File");
             }
             catch(IOException e){
                 System.out.println("Error: "+e.getMessage());
             }
            }
            else if (choice == 8){
                System.out.println("Exiting...");
                break;
            }
        }
    }
}

