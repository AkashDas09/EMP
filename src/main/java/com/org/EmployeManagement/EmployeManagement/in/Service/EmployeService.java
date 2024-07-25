package com.org.EmployeManagement.EmployeManagement.in.Service;

import java.util.List;

import com.org.EmployeManagement.EmployeManagement.in.model.Employe;

public interface EmployeService {
     public Employe createEMP(Employe em);
     public List<Employe> fetchallEMP();
     public void deleteEMP(int id);
     public List<Employe> fetchbyname(String name);
     public Employe getbyid(int id);
     public List<Employe> fetchbyddepartment(String department);
     public List<Employe> fetchbypassword(String password);
     public List<Employe> fetchbyemailAndpassword(String email,String password);
}
