package com.example.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.*;
import java.util.*;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Transactional
    public String transferStudent(int studentId, int teacherId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        try {
            if (student == null) {
                logger.warn("Student not found");
                return "Student Not Found";
            }

            Teacher newTeacher = teacherRepository.findById(teacherId).orElse(null);
            if (newTeacher == null) {
                logger.warn("Teacher Not Found");
                return "Teacher Not Found";
            }
            logger.info("Transforing Student" + student.getName() + newTeacher.getName());
            student.setTeacher(newTeacher);
            studentRepository.save(student);
            logger.info("Transfer Successfuly");
            return "Student Tansfered Successfuly";
        } catch (Exception e) {
            logger.error("Transfer Failed" + e.getMessage());
            throw new RuntimeException("Transfer Failed" + e.getMessage());
        }
    }

    @Transactional
    public String addStudentWithTeacher(Student student, int teacherId) {

        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        try {
            if (teacher == null) {
                return "Teacher not found";
            }
            student.setTeacher(teacher);

            if (teacher.getStudents() == null) {
                teacher.setStudents(new ArrayList<>());
            }
            teacher.getStudents().add(student);
            studentRepository.save(student);
            teacherRepository.save(teacher);
            logger.info("Student added to Teacher: " + teacher.getName());
            return "Student Added Successfuly";
        }catch(Exception e){
            logger.error("Error: "+e.getMessage());
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }
}