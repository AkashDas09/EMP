package com.org.EmployeManagement.EmployeManagement.in.model;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Component;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
@Component
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      private String name;
      private String email;
      private String mobile;
      private int age;
      private String role;
      private String date;
      private String city;
      private String password;
      private String address;
      private String department;
      @Lob
      private Blob image;
      private boolean active = true;

      @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
      private List<Attendance> attendances;
      
}
