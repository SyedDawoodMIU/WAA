package com.waa.assignments.entity.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Time time;
    private String principle;
    private String operation;



    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public void setDate(LocalDateTime time) {
        this.date = Date.valueOf(time.toLocalDate());
        this.time = Time.valueOf(time.toLocalTime());
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

