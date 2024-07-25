package com.org.EmployeManagement.EmployeManagement.in.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.EmployeManagement.EmployeManagement.in.Service.AttendanceServicee;
import com.org.EmployeManagement.EmployeManagement.in.Service.EmployeServiceImpl;
import com.org.EmployeManagement.EmployeManagement.in.model.Admin;
import com.org.EmployeManagement.EmployeManagement.in.model.Attendance;
import com.org.EmployeManagement.EmployeManagement.in.model.Employe;

import jakarta.servlet.http.HttpSession;
@Controller
public class AdminController {
	@Autowired
	private EmployeServiceImpl impl;
	@Autowired
	private AttendanceServicee asimpl;
	@PostMapping("/ADMINLOGIN")
      public String loginadmin(@RequestParam String name,@RequestParam String password,Model model) {
    	 if(name.equals("Admin")&&password.equals("admin@123")) {
    		 model.addAttribute("adminn",new Admin());
    		 return "admin/AdminHome";
    	 }
    	 else {
    		 model.addAttribute("wrong","invalid name or password");
    		 return "admin/Adminlogin";
    	 }
      }
      @GetMapping("/registerpage")
      public String gotologin() {
    	  return "admin/Adminlogin";
      }
      @GetMapping("/addemploye")
      public String fghj() {
    	  return "register";
      }
      @GetMapping("/viewallEmploye")
    	public String fetchall(Model model) {
    	  List<Employe> fetchallEMP = impl.fetchallEMP();
    	  model.addAttribute("fetch",fetchallEMP);
    	  return "admin/adminviewEmploye";
      }
      @GetMapping("/displayimage")
      public ResponseEntity<byte[]> displayImage(@RequestParam("id") int id) throws IOException, SQLException
      {
          Employe image = impl.getbyid(id);
          byte [] imageBytes = null;
          imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
          return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
      }
      @GetMapping("/search")
      public String fetchbyname(@RequestParam String name,Model model) {
    	  List<Employe> fetchbyname = impl.fetchbyname(name);
    	  model.addAttribute("fetchyname",fetchbyname);
    	  return "admin/adminviewbyname";
      }
      @GetMapping("/deleteEMPid/{id}")
      public String deleteEMP(@RequestParam("id") int id,HttpSession session) {
    	  impl.deleteEMP(id);
    	  return "admin/adminviewbyname";
      }
      @GetMapping("/hiringpages")
      public String hj() {
    	  
    	  return "admin/hiringpage";
      }
      @GetMapping("/sendingurl")
      public String gh() {
    	  return "sendmail";
      }
      @GetMapping("/searched")
       public String fetchbydepartment(@RequestParam String department,Model model) {
    	  List<Employe> fetchbyddepartment = impl.fetchbyddepartment(department);
    	  model.addAttribute("department",fetchbyddepartment);
    	  return "admin/adminviewbydepartment";
    	  
      }
      @GetMapping("/aboutpage")
      public String hhj() {
    	  return "about";
      }
      @GetMapping("/attendance")
      public String fetchalll(Model model) { 
    	  List<Employe> fetchallEMP = impl.fetchallEMP();
    	  model.addAttribute("fetch",fetchallEMP);
    	  return "admin/adminviewEmploye";
      }
      @GetMapping("/allattendance")
      public String attendanceview(Model model) { 	  
    	  List<Attendance> allAttendanceWithEmployees = asimpl.getAllAttendanceWithEmployees();
    	 
    	  model.addAttribute("fetchAttendances",allAttendanceWithEmployees);
    	  return "Admin/adminviewattendance";
      }
      @GetMapping("/gotohome")
      public String gotohome() {
    	  return "Home";
      }
      @GetMapping("/gohome")
      public String bn() {
    	  return "Home";
      }
      @GetMapping("/goohome")
      public String fglhj() {
    	  return "Home";
      }
      @GetMapping("/goohomee")
      public String tyjdnmfjjh() {
    	  return "review";
      }
      @GetMapping("/gooohomee")
      public String ftyujfnv() {
    	  return "Home";
      }
      @GetMapping("/adhome")
      public String dfgf() {
    	  return "admin/AdminHome";
      }
      @GetMapping("/adhom")
      public String ghjdf() {
    	  return "admin/AdminHome";
      }
      @GetMapping("/atthomee")
      public String thd() {
    	  return "admin/AdminHome";
      }
}
