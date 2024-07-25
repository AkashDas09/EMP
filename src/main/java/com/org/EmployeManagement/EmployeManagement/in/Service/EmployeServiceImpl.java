package com.org.EmployeManagement.EmployeManagement.in.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.org.EmployeManagement.EmployeManagement.in.Repo.EmployeRepo;
import com.org.EmployeManagement.EmployeManagement.in.model.Employe;
@Service
public class EmployeServiceImpl implements EmployeService{
    @Autowired
    private EmployeRepo repo; 
	@Override
	public Employe createEMP(Employe em) {
		// TODO Auto-generated method stub
		return repo.save(em);
	}

	@Override
	public List<Employe> fetchallEMP() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteEMP(int id) {
		//Category category = categoryRepository.findById(id).orElse(null);
          repo.deleteById(id);
	}

	@Override
	public List<Employe> fetchbyname(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public Employe getbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Employe> fetchbyddepartment(String department) {
		// TODO Auto-generated method stub
		return repo.findByDepartment(department);
	}

	@Override
	public List<Employe> fetchbyemailAndpassword(String email, String password) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<Employe> fetchbypassword(String password) {
		// TODO Auto-generated method stub
		return repo.findByPassword(password);
	}

	

}
