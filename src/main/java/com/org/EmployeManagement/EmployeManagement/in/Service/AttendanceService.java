package com.org.EmployeManagement.EmployeManagement.in.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.EmployeManagement.EmployeManagement.in.Repo.AttendanceRepository;
import com.org.EmployeManagement.EmployeManagement.in.Repo.EmployeRepo;
import com.org.EmployeManagement.EmployeManagement.in.model.Attendance;
import com.org.EmployeManagement.EmployeManagement.in.model.Employe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService implements AttendanceServicee {

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private EmployeRepo employeeRepository;

	@Override
	public Attendance getbyid(int id) {
		// TODO Auto-generated method stub
		return attendanceRepository.getById(id);
	}

	@Override
	public List<Attendance> getAllAttendances() {
		return attendanceRepository.findAll();
	}

//	@Override
//	public List<Attendance> getMonthlyAttendance(int employeeId, LocalDate month) {
//		LocalDate startDate = month.withDayOfMonth(1);
//		LocalDate endDate = month.withDayOfMonth(month.lengthOfMonth());
//		return attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
//	}

	@Override
	public void saveattendance(int employeeId, String status,LocalDateTime eventDateTime) {
		Attendance attendance = new Attendance();
		Employe employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
		attendance.setEmployee(employee);
		attendance.setStatus(status);
		attendance.setEventDateTime(eventDateTime);
		attendanceRepository.save(attendance);
	}

	//@Override
//	public List<Attendance> fetchbydate() {
//		// TODO Auto-generated method stub
//		return attendanceRepository.findByDate();
//	}

	@Override
	public List<Attendance> getAttendanceByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return attendanceRepository.findByEmployeeId(employeeId);
	}

	@Override
	public List<Attendance> getAllAttendanceWithEmployees() {
		// TODO Auto-generated method stub
		return attendanceRepository.findAll();
	}

}
