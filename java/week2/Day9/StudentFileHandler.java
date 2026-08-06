import java.io.*;
class StudentFileHandler{
    public void saveStudent(String fileName,String name,int age,int marks)throws IOException{
         try {
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
             bw.write(name+" "+age+" "+marks);
             bw.newLine();
             bw.close();
         }
         catch(IOException e){
             System.out.println("Error: "+e.getMessage());
         }
    }
    public void readStudent(String fileName)throws IOException{
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String [] args){
        StudentFileHandler student = new StudentFileHandler();
        try {
            student.saveStudent("Student.txt", "Jagan", 21, 96);
            student.saveStudent("Student.txt", "Siva", 23, 95);
            student.saveStudent("Student.txt", "Raj", 28, 99);
            student.readStudent("Student.txt");
        }
        catch(IOException e){
            System.out.println("file not found"+e.getMessage());
        }
    }
}