package com.org.EmployeManagement.EmployeManagement.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.EmployeManagement.EmployeManagement.in.Service.EmployeServiceImpl;
import com.org.EmployeManagement.EmployeManagement.in.Service.ReviewServiceImpl;
import com.org.EmployeManagement.EmployeManagement.in.model.Employe;
import com.org.EmployeManagement.EmployeManagement.in.model.Review;

import jakarta.servlet.http.HttpSession;
@Controller
public class ReviewController {
	@Autowired
	private EmployeServiceImpl esi;
	@Autowired
	private ReviewServiceImpl rsi;
	@GetMapping("/viewreview")
    public String virereview() {
  	  return "review";
    }
	@GetMapping("/HOME")
	public String hjkdf() {
		return "Home";
	}
	@PostMapping("/EMPLOGINreview")
	public String EmployeLogin(@RequestParam String email, @RequestParam String password, Model model,
			HttpSession session) {
		List<Employe> fetchbyemailAndpassword = esi.fetchbyemailAndpassword(email, password);
		if (fetchbyemailAndpassword.isEmpty()) {
			model.addAttribute("notloginr", "Invalid Email Or password");
			return "AddReview";
		} else {
			session.setAttribute("EmployeObjr", fetchbyemailAndpassword.get(0));
			return "Reviewadded";
		}

	}
	@PostMapping("/addrev")
	public String add(@ModelAttribute Review rr,Model model) {
		Review addReview = rsi.addReview(rr);
		return "review";
	}
	@GetMapping("/addreviw")
	public String fghjkfgdc() {
		return "AddReview";
	}
	@GetMapping("/viewreviewall")
	public String gsjdf(Model model) {
		List<Review> viewAllReview = rsi.viewAllReview();
		model.addAttribute("viewre",viewAllReview);
		return "reviewview";
		
	}
}
