package com.org.EmployeManagement.EmployeManagement.in.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.EmployeManagement.EmployeManagement.in.model.Employe;

public interface EmployeRepo extends JpaRepository<Employe, Integer>{
List<Employe> findByName(String name);
List<Employe> findByDepartment(String department);
List<Employe> findByPassword(String password);
@Query("select s from Employe s where s.email=?1 and s.password=?2")
List<Employe> findByEmailAndPassword(String email,String password);
}
