package com.masai.models;

public class Problem {

	private int    complain_Id;
	private String Problem_Name;
	private String Problem_category;
	private String Problem_status;
	private String Problem_engineerId;
	private String Problem_employeeID;
	public int getComplain_Id() {
		return complain_Id;
	}
	public void setComplain_Id(int complain_Id) {
		this.complain_Id = complain_Id;
	}
	public String getProblem_Name() {
		return Problem_Name;
	}
	public void setProblem_Name(String problem_Name) {
		Problem_Name = problem_Name;
	}
	public String getProblem_category() {
		return Problem_category;
	}
	public void setProblem_category(String problem_category) {
		Problem_category = problem_category;
	}
	public String getProblem_status() {
		return Problem_status;
	}
	public void setProblem_status(String problem_status) {
		Problem_status = problem_status;
	}
	public String getProblem_engineerId() {
		return Problem_engineerId;
	}
	public void setProblem_engineerId(String problem_engineerId) {
		Problem_engineerId = problem_engineerId;
	}
	public String getProblem_employeeID() {
		return Problem_employeeID;
	}
	public void setProblem_employeeID(String problem_employeeID) {
		Problem_employeeID = problem_employeeID;
	}
	@Override
	public String toString() {
		return "Problem [complain_Id=" + complain_Id + ", Problem_Name=" + Problem_Name + ", Problem_category="
				+ Problem_category + ", Problem_status=" + Problem_status + ", Problem_engineerId=" + Problem_engineerId
				+ ", Problem_employeeID=" + Problem_employeeID + "]";
	}
	public Problem() {
		// TODO Auto-generated constructor stub
	}
	
	public Problem(int complain_Id, String problem_Name, String problem_category, String problem_status,
			String problem_engineerId, String problem_employeeID) {
		super();
		this.complain_Id = complain_Id;
		Problem_Name = problem_Name;
		Problem_category = problem_category;
		Problem_status = problem_status;
		Problem_engineerId = problem_engineerId;
		Problem_employeeID = problem_employeeID;
	}
	
	
	public Problem( String problem_Name, String problem_category, String problem_status,
			String problem_engineerId, String problem_employeeID) {
		super();
		
		Problem_Name = problem_Name;
		Problem_category = problem_category;
		Problem_status = problem_status;
		Problem_engineerId = problem_engineerId;
		Problem_employeeID = problem_employeeID;
	}
	public Problem( String problem_Name, String problem_category, String problem_status,
			 String problem_employeeID) {
		super();
		
		Problem_Name = problem_Name;
		Problem_category = problem_category;
		Problem_status = problem_status;
		
		Problem_employeeID = problem_employeeID;
	}
	
}
