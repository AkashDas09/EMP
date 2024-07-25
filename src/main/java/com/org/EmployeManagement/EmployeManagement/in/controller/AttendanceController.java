package com.org.EmployeManagement.EmployeManagement.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.org.EmployeManagement.EmployeManagement.in.Service.AttendanceServicee;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceServicee attendanceService;

    @GetMapping("/mark")
    public String markAttendanceForm(@RequestParam int employeeId, Model model) {
        model.addAttribute("employeeId", employeeId);
        return "markAttendance";
    }
 
    @PostMapping("/mark")
    public String markAttendance(@RequestParam int employeeId,
                                 @RequestParam String status,@RequestParam LocalDateTime eventDateTime,Model model) {
        attendanceService.saveattendance(employeeId, status,eventDateTime);
        model.addAttribute("AttendanceDone","Attendance Done");
        return "markAttendance";
    }
}
