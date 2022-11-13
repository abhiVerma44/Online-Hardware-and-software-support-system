package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.models.Employee;
import com.masai.models.Problem;
import com.masai.utility.DBUtil;

public class Employee_daoImpl implements Employee_dao{

	@Override
	public String RegisterAsEmployee(Employee emp) {
        String message = "";
		
		try( Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("insert into Employee(name, username,password ) values(?,?,?)");
			
			pt.setString(1, emp.getName());
			pt.setString(2, emp.getUsername());
			pt.setString(3, emp.getPassword());
			
			int x = pt.executeUpdate();
			if(x>0) {
				message = "Employee succesfuly register....";
				System.out.println(message);
			}else {
				message = "You have enter somethink wrong details";
				System.out.println(message);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String LiginAsEmployee(String email, String password) {
		String message = "";
		
        try( Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("select * from Employee where username = ? AND password = ?");
			pt.setString(1, email);
			pt.setString(2, password);
			
			ResultSet rSet = pt.executeQuery();
			if(rSet.next()) {
				message = "Welcome"+rSet.getString("name");
				System.out.println(message);
			}else {
				message = "Employee deosn't exits with "+email;
				System.out.println(message);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String raiseProblem(Problem p1) {
       String prblmString = "Problem can't raise...";
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement pr = conn.prepareStatement("insert into Problem (Problem_Name,Problem_category,Problem_status,Problem_employeeID) values(?,?,?,?)");
			
			pr.setString(1, p1.getProblem_Name());
			pr.setString(2, p1.getProblem_category());
			pr.setString(3, p1.getProblem_status());
			pr.setString(4, p1.getProblem_employeeID());
			
			int x = pr.executeUpdate();
			if(x>0) {
				prblmString = "Register successfull...";
				System.out.println(prblmString);
			}else {
				prblmString = "you have entered somethink wrong credential";
				System.out.println(prblmString);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return prblmString;
	}

	@Override
	public String checkStatus(int complainId, String employeeID) {
		  String message = "";
		
	       try (Connection conn = DBUtil.provideconnection()){
				
				PreparedStatement pr = conn.prepareStatement("Select * from Problem p INNER JOIN Employee e ON p.Problem_employeeID = e.employeeId AND p.Problem_employeeID = ? and p.complain_Id = ?");
				
				pr.setString(1, employeeID);
				pr.setInt(2, complainId);
				
				
				ResultSet x = pr.executeQuery();
				if(x.next()) {
					
					message = "your problem Assigned to "+x.getString("Problem_engineerId");
					System.out.println(message);
					
				}else {
				
					message = "you didn't raise any problems....";
					System.out.println(message);
					
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			
			
			return message;
	}

	@Override
	public List<Problem> ComplainHistory(String employeeID) {
      List <Problem> lstEmployees = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideconnection()) {
			
			
			PreparedStatement pt = conn.prepareStatement("select * from Problem where Problem_employeeID = ?");
			pt.setString(1, employeeID);
			ResultSet rSet = pt.executeQuery();
			
			while(rSet.next()) {
				
				int complainId = rSet.getInt("complain_Id");
				String problem = rSet.getString("Problem_Name");
				String Category = rSet.getString("Problem_category");
				String Status = rSet.getString("Problem_status");
				String EngineerId = rSet.getString("Problem_engineerId");
				String EmployeeId = rSet.getString("Problem_employeeID");
				
				
				Problem p = new Problem(complainId,problem,Category,Status,EngineerId,EmployeeId);
				lstEmployees.add(p);	
			}
			if(!rSet.next()) {
				System.out.println("You didn't raise any problem till now");
			}
			
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return lstEmployees;
	}

	@Override
	public String changePassword(String Username, String oldPassword, String newpassword) {
       String messaString = "";
		
		try(Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("update Employee set password = ? where username = ? AND password = ?");
			pt.setString(1, newpassword);
			pt.setString(2, Username);
			pt.setString(3, oldPassword);
			
			int x = pt.executeUpdate();
			if(x>0) {
				messaString = "Successfully Password changed";
				System.out.println(messaString);
			}else {
				messaString = "You have entered somethink wrong details";
				System.out.println(messaString);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return messaString;
	}

}
