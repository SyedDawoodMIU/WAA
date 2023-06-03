package com.example.mockexam1.entity;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    @OneToOne(cascade = CascadeType.ALL)
    private CourseDetails courseDetails;


}