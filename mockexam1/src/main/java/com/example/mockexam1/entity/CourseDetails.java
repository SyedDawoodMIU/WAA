package com.example.mockexam1.entity;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class CourseDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String description;

    private String program;

    @OneToOne(mappedBy = "courseDetails", cascade = CascadeType.ALL)
    private Course course;

}