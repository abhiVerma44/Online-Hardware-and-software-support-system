package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.models.Engineer;
import com.masai.models.Problem;
import com.masai.utility.DBUtil;

public class HOD_daoImpl implements HOD_dao{

	@Override
	public String HOD_Login(String username, String password) {
       String message = "Invailid username Or password";
		
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from HOD where  HOD_username = ? AND HOD_password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				message = "Wecome "+ rs.getString("HOD_name");
				System.out.println(message);
			}else {
				System.out.println(message);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String RegisterNewEngineerByHod(Engineer eng) {
		 String message = "Can't Register in the Engineer";
			
			
			try (Connection conn = DBUtil.provideconnection()){
				
				PreparedStatement pt = conn.prepareStatement("Insert into Engineer(Engineer_name,Engineer_username, Engineer_password,Engineer_category) values(?,?,?,?)");
				
				
				pt.setString(1, eng.getEngineer_name());
				pt.setString(2, eng.getEngineer_username());
				pt.setString(3, eng.getEngineer_password());
				pt.setString(4, eng.getEngineer_category());
				
				
				int x = pt.executeUpdate();
				
				if(x>0) {
					message = eng.getEngineer_name()+ " succesfully register inside the engineers database";
					System.out.println(message);
				}else {
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			return message; 
	}

	@Override
	public List<Engineer> List_of_all_Registered_Engineers() {
		List<Engineer> li = new ArrayList<>() ;
		try(Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("select * from Engineer");
			
			ResultSet rSet = pt.executeQuery();
			while(rSet.next()) {
				int engineerId = rSet.getInt("Engineer_Id");
				String Name = rSet.getString("Engineer_name");
				String Email = rSet.getString("Engineer_username");
				String Password = rSet.getString("Engineer_password");
				String Category = rSet.getString("Engineer_category");
				
				
				Engineer E1 = new Engineer(engineerId,Name,Email,Password,Category);
				li.add(E1);
				
				
			}
			if(!rSet.next())
			{
				System.out.println("Engineers Database is empty.....");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return li;
	}

	@Override
	public String deleteengineerS(String eId) {
     String string = "Incorrect eid......";
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement pt = conn.prepareStatement("delete from Engineer where Engineer_Id = ?");
			pt.setString(1, eId);
			int x = pt.executeUpdate();
			if(x>0) {
				string = eId + " Is delete from the engineers database.....";
				System.out.println(string);
			}else {
				System.out.println(string);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return string;
	}

	@Override
	public List<Problem> getProblembDetails() {
		List<Problem> problems = new ArrayList<>() ;
		try(Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("select * from Problem");
			
			ResultSet rSet = pt.executeQuery();
			while(rSet.next()) {
				int complainid = rSet.getInt("complain_Id");
				String ProblemName = rSet.getString("Problem_Name");
				String category = rSet.getString("Problem_category");
				String Status = rSet.getString("Problem_status");
				String EngineerId = rSet.getString("Problem_engineerId");
				String EmployeeID = rSet.getString("Problem_employeeID");
				
				
				Problem p = new Problem(complainid,ProblemName,category,Status,EngineerId,EmployeeID);
				problems.add(p);
				
				
			}
			if(!rSet.next())
			{
				System.out.println("Probme database is empty...");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return problems;
	}

	@Override
	public String AssignProblemToEngineer(int complainId, String EngineerID) {
		
	       String meString = "Somethink went wrong in assigning..";
			
			try (Connection conn = DBUtil.provideconnection()){
				
				PreparedStatement pt = conn.prepareStatement("update Problem set Engineer_Id = ? where complain_Id = ?");
				pt.setString(1, EngineerID);
				pt.setInt(2, complainId);
				int x = pt.executeUpdate();
				if(x>0) {
					meString = EngineerID+" assigned to "+ complainId +" problem";
					System.out.println(meString);
				}else {
					System.out.println(meString);
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			
			
			
			return meString;
	}



}
