package com.org.EmployeManagement.EmployeManagement.in.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.EmployeManagement.EmployeManagement.in.Repo.ReviewRepo;
import com.org.EmployeManagement.EmployeManagement.in.model.Review;
@Service
public class ReviewServiceImpl implements ReviewService{
     @Autowired
     private ReviewRepo repo;
	@Override
	public Review addReview(Review re) {
		// TODO Auto-generated method stub
		return repo.save(re);
	}

	@Override
	public List<Review> viewAllReview() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
