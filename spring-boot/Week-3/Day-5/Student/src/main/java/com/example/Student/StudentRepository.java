package com.example.Student;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT s FROM Student s Where"+"(:name IS NULL OR s.name LIKE %:name% ) AND "+"(:minMarks IS NULL OR s.marks >= :minMarks) AND"+"(:maxMarks IS NULL OR s.marks<= :maxMarks)")
    Page<Student> filterStudents(
            @Param("name") String name,
            @Param("minMarks") Integer minMarks,
            @Param("maxMarks") Integer maxMarks,
            Pageable pageable
    );
}