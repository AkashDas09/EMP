package com.org.EmployeManagement.EmployeManagement.in.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.org.EmployeManagement.EmployeManagement.in.model.Attendance;

public interface AttendanceServicee {
	public void saveattendance(int employeeId,  String status,LocalDateTime eventDateTime);
    public Attendance getbyid(int id);
    public List<Attendance> getAllAttendances();
//    public List<Attendance> getMonthlyAttendance(int employeeId, LocalDate month) ;
   // public List<Attendance> fetchbydate();
    public List<Attendance> getAttendanceByEmployeeId(int employeeId);
    public List<Attendance> getAllAttendanceWithEmployees();
}
