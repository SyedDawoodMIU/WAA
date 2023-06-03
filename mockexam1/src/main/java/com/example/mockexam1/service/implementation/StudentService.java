package com.example.mockexam1.service.implementation;

import com.example.mockexam1.entity.Course;
import com.example.mockexam1.entity.Student;
import com.example.mockexam1.repo.StudentRepository;
import com.example.mockexam1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(int id, Student student) {
        if (studentRepository.existsById(id))
        {
            return studentRepository.save(student);

        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Course> getCoursesByStudent(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return student.getCourses();
        }
        return null;
    }

    @Override
    public List<Student> getStudentsWithGpaLessThanOrEqual(double gpa) {
        return studentRepository.findByGpaLessThanEqual(gpa);
    }

    @Override

    public List<Student> getStudentsInMscWithGpaLessThan(double gpa) {
        return studentRepository.findMscStudentsWithGpaLessThan(gpa);
    }
}
