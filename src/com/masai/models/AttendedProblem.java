package com.masai.models;

public class AttendedProblem {

	private int complainId;
	private String AttendedProblem_Name;
	private String AttendedProblem_category;
	private String AttendedProblem_status;
	private String AttendedProblem_engineerId;
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public String getAttendedProblem_Name() {
		return AttendedProblem_Name;
	}
	public void setAttendedProblem_Name(String attendedProblem_Name) {
		AttendedProblem_Name = attendedProblem_Name;
	}
	public String getAttendedProblem_category() {
		return AttendedProblem_category;
	}
	public void setAttendedProblem_category(String attendedProblem_category) {
		AttendedProblem_category = attendedProblem_category;
	}
	public String getAttendedProblem_status() {
		return AttendedProblem_status;
	}
	public void setAttendedProblem_status(String attendedProblem_status) {
		AttendedProblem_status = attendedProblem_status;
	}
	public String getAttendedProblem_engineerId() {
		return AttendedProblem_engineerId;
	}
	public void setAttendedProblem_engineerId(String attendedProblem_engineerId) {
		AttendedProblem_engineerId = attendedProblem_engineerId;
	}
	public AttendedProblem() {
		// TODO Auto-generated constructor stub
	}
	
	public AttendedProblem(int complainId, String attendedProblem_Name, String attendedProblem_category,
			String attendedProblem_status, String attendedProblem_engineerId) {
		super();
		this.complainId = complainId;
		AttendedProblem_Name = attendedProblem_Name;
		AttendedProblem_category = attendedProblem_category;
		AttendedProblem_status = attendedProblem_status;
		AttendedProblem_engineerId = attendedProblem_engineerId;
	}
	public AttendedProblem( String attendedProblem_Name, String attendedProblem_category,
			String attendedProblem_status, String attendedProblem_engineerId) {
		super();
		
		AttendedProblem_Name = attendedProblem_Name;
		AttendedProblem_category = attendedProblem_category;
		AttendedProblem_status = attendedProblem_status;
		AttendedProblem_engineerId = attendedProblem_engineerId;
	}
	@Override
	public String toString() {
		return "AttendedProblem [complainId=" + complainId + ", AttendedProblem_Name=" + AttendedProblem_Name
				+ ", AttendedProblem_category=" + AttendedProblem_category + ", AttendedProblem_status="
				+ AttendedProblem_status + ", AttendedProblem_engineerId=" + AttendedProblem_engineerId + "]";
	}
	
}
