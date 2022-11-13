package com.masai.dao;

import java.util.List;

import com.masai.models.Employee;
import com.masai.models.Problem;

public interface Employee_dao {

   public String RegisterAsEmployee(Employee emp);
	
	
	public String LoginAsEmployee(String email, String password);

	
	public String raiseProblem(Problem p1);
	
	
	public String checkStatus(int complainId,String employeeID);
	
	
	public List<Problem> ComplainHistory(String employeeID);
	
	
	public String changePassword(String Username, String oldPassword,String newpassword);
}
