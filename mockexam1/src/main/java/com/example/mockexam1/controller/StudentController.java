package com.example.mockexam1.controller;

import com.example.mockexam1.entity.Course;
import com.example.mockexam1.entity.Student;
import com.example.mockexam1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public List<Student> findAll(@RequestParam(required = false) Double gpa,
                                 @RequestParam(required = false, defaultValue = "false") Boolean msc){
        if (msc && gpa != null){
            return studentService.getStudentsInMscWithGpaLessThan(gpa);
        } else if (gpa != null){
            return studentService.getStudentsWithGpaLessThanOrEqual(gpa);
        }
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        studentService.deleteById(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudent(@PathVariable int id){
        return studentService.getCoursesByStudent(id);
    }

}

