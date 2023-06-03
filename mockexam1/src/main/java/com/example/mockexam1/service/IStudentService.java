package com.example.mockexam1.service;

import com.example.mockexam1.entity.Course;
import com.example.mockexam1.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    Student update(int id, Student student);

    void deleteById(int id);

    List<Course> getCoursesByStudent(int id);

    List<Student> getStudentsWithGpaLessThanOrEqual(double gpa);

    List<Student> getStudentsInMscWithGpaLessThan(double gpa);
}
