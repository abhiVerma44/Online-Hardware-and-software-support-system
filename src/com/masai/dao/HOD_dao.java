package com.masai.dao;

import java.util.List;

import com.masai.models.Engineer;
import com.masai.models.Problem;

public interface HOD_dao {

	public String HOD_Login(String username,String password);
	
	public String RegisterNewEngineerByHod(Engineer eng);
	
	public List<Engineer> List_of_all_Registered_Engineers();
	
	public String deleteengineerS(String eId);
	
    public List<Problem> getProblembDetails();
	
	
	public String AssignProblemToEngineer(int complainId, String EngineerID);
}
