package com.org.EmployeManagement.EmployeManagement.in.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@Component
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int reviewrating;
    private String comment;
    private String name;
    
}
