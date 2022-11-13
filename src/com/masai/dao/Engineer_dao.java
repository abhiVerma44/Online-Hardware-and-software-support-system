package com.masai.dao;

import java.util.List;

import com.masai.models.AttendedProblem;
import com.masai.models.Problem;

public interface Engineer_dao {

	public String LoginAsEngineer(String Email,String password);

	
	public List<Problem> GetAssignedProblems(String engineerID);
	
	
	public String UpdateStatus(String statuString, int complainId,String engineerId);
	
	
	public List<AttendedProblem> getAttendedProblems(String engineerID);
	
	
	public String ChangePassword(String Email,String oldPassword,String newPassword);
}
