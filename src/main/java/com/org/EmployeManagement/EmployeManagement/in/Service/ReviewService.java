package com.org.EmployeManagement.EmployeManagement.in.Service;

import java.util.List;

import com.org.EmployeManagement.EmployeManagement.in.model.Review;

public interface ReviewService {
   public Review addReview(Review re);
   public List<Review> viewAllReview();
}
