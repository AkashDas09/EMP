package com.org.EmployeManagement.EmployeManagement.in.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.org.EmployeManagement.EmployeManagement.in.Service.EmployeServiceImpl;
import com.org.EmployeManagement.EmployeManagement.in.model.Employe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeController {
	@Autowired
	private EmployeServiceImpl esi;

	@GetMapping("/view")
	public String go() {
		return "totalemploye";
	}

	@PostMapping("/saveEmp")
	public String createemp(@RequestParam("image") MultipartFile file, @RequestParam String name,
			@RequestParam String email, @RequestParam String mobile, @RequestParam int age, @RequestParam String role,
			@RequestParam String date, @RequestParam String city, @RequestParam String password,
			@RequestParam String address, @RequestParam String department,@RequestParam boolean active ,HttpServletRequest req, Model model)
			throws IOException, SerialException, SQLException {
		if (file.isEmpty()) {
			model.addAttribute("error", "Please select a file to upload.");
			return "register";
		}
		byte[] bytes = file.getBytes();
		Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		Employe em = new Employe();
		em.setName(name);
		em.setEmail(email);
		em.setMobile(mobile);
		em.setAge(age);
		em.setRole(role);
		em.setDate(date);
		em.setCity(city);
		em.setPassword(password);
		em.setAddress(address);
		em.setDepartment(department);
		em.setImage(blob);
		em.setActive(active);
		esi.createEMP(em);
		model.addAttribute("employe", "Employe add successfull...");
		return "admin/AdminHome";
	}

//	@GetMapping("/fastone")
//	public String goo() { 
//		return "register";
//	}
	@GetMapping("Employe.in")
	public String employehomme() {
		return "Home";
	}

//	@GetMapping("/registerpage")
//	public String fgh() {
//		return "register";
//	}
	@GetMapping("/registerpagee")
	public String dfdd() {
		return "login";
	}

	@PostMapping("/EMPLOGIN")
	public String EmployeLogin(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession session) {
		List<Employe> fetchbyemailAndpassword = esi.fetchbyemailAndpassword(email, password);
		if (fetchbyemailAndpassword.isEmpty()) {
			model.addAttribute("notlogin", "Invalid Email Or password");
			return "login";
		} else {
			session.setAttribute("EmployeObj", fetchbyemailAndpassword.get(0));
			return "EmployeHome";
		}

	}

//	@GetMapping("/myprofile")
//	public String myprofile(@RequestParam("id") int id,Model model) {
//		Employe getbyid = esi.getbyid(id);
//		model.addAttribute("fetchbyid",getbyid);
//		return "viewmyprofile";
//	}
	@GetMapping("/displayimagee")
	public ResponseEntity<byte[]> displayImage(@RequestParam("id") int id) throws IOException, SQLException {
		Employe image = esi.getbyid(id);
		byte[] imageBytes = null;
		imageBytes = image.getImage().getBytes(1, (int) image.getImage().length());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	@GetMapping("/searchedpassword")
	public String fetchbypasswordd(@RequestParam String password, Model model) {
		List<Employe> fetchbypassword = esi.fetchbypassword(password);
		model.addAttribute("fetchced", fetchbypassword);
		return "viewmyprofile";
	}

	@GetMapping("/updateEMPid/{id}")
	public String updateEMp(@PathVariable int id, Model model) {
		Employe getbyid = esi.getbyid(id);
		model.addAttribute("Employeid", getbyid);
		return "update";
	}

	@PostMapping("/EDITEmp")
	public String updatedone(Model model, @RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam String mobile, @RequestParam int age, @RequestParam String role,@RequestParam String date, @RequestParam String city,
			@RequestParam String password, @RequestParam String address,@RequestParam boolean active,@RequestParam String department, @RequestParam("image") MultipartFile file)
			throws IOException, SerialException, SQLException {

		byte[] bytes = file.getBytes();
		Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		Employe em = new Employe();
		em.setId(id);
		em.setName(name);
		em.setEmail(email);
		em.setMobile(mobile);
		em.setAge(age);
		em.setRole(role);
		em.setDate(date);
		em.setCity(city);
		em.setPassword(password);
		em.setAddress(address);
		em.setDepartment(department);
		em.setImage(blob);
		em.setActive(active);
		esi.createEMP(em);
		model.addAttribute("EMploye", "Update Successfull...");
		return "EmployeHome";
	}
	@GetMapping("/myprofiletohome")
	public String ghshs() {
		return "EmployeHome";
	}
	@GetMapping("/mohome")
	public String myhome() {
		return "login";
	}
	
}
