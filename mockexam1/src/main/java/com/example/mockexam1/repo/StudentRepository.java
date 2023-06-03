package com.example.mockexam1.repo;

import com.example.mockexam1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE s.gpa <= :gpa")
    List<Student> findByGpaLessThanEqual(double gpa);

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseDetails.program = 'MSC' AND s.gpa < :gpa")
    List<Student> findMscStudentsWithGpaLessThan(double gpa);
}
