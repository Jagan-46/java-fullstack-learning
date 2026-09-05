package com.example.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByName(String name);

    List<Student> findByNameAndMarks(String name, int marks);

    List<Student> findByMarksGreaterThan(int marks);

    List<Student> findByMarksLessThan(int marks);

    List<Student> findByMarksBetween(int minMarks, int MaxMarks);

    long countByName(String name);
}