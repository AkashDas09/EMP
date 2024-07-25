package com.org.EmployeManagement.EmployeManagement.in.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.EmployeManagement.EmployeManagement.in.model.Attendance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	/*
	 * List<Attendance> findByEmployeeIdAndDateBetween(int employeeId, LocalDate
	 * startDate, LocalDate endDate);
	 *///    @Query("select s from Attendance s order by s.date ASC")
//    List<Attendance> findByDate();
    List<Attendance> findByEmployeeId(int employeeId);
}
