package com.waa.assignments.entity.business;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionEntity extends Logger{
    private String exception;

    public void setException(String exception) {
        this.exception = exception;
    }

}
