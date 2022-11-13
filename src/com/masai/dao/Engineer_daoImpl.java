package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.models.AttendedProblem;
import com.masai.models.Problem;
import com.masai.utility.DBUtil;

public class Engineer_daoImpl implements Engineer_dao{

	@Override
	public String LoginAsEngineer(String Email, String password) {
      String string = "Invalid Email or Password.....";
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement pt = conn.prepareStatement("select * from Engineer where Engineer_username = ? AND Engineer_password = ?");
			
			pt.setString(1, Email);
			pt.setString(2, password);
			
			ResultSet rSet = pt.executeQuery();
			
			if(rSet.next()) {
				string = "Wecome "+ rSet.getString("Engineer_name");
				System.out.println(string);
			}else {
				System.out.println(string);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return string;
	}

	@Override
	public List<Problem> GetAssignedProblems(String engineerID) {
		List<Problem> p1 = new ArrayList<>() ;
		try(Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("select * from Problem p INNER JOIN  Engineer e ON e.Engineer_Id = p.Problem_engineerId AND p.Problem_engineerId = '"+engineerID+"'");
			
			ResultSet rSet = pt.executeQuery();
			while(rSet.next()) {
				int complainId = rSet.getInt("complain_Id");
				String problem = rSet.getString("Problem_Name");
				String category = rSet.getString("Problem_category");
				String status = rSet.getString("Problem_status");
				String engineerId = rSet.getString("Problem_engineerId");
				String employeeID = rSet.getString("Problem_employeeID");
				
				Problem prb = new Problem(complainId,problem,category,status,engineerId,employeeID);
				p1.add(prb);
				
				
			}
			if(rSet.next()==false)
			{
				System.out.println("Problems are not assinged....");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return p1;
	}

	@Override
	public String UpdateStatus(String statuString, int complainId, String engineerId) {
      String meString = "";
		
        
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement pt = conn.prepareStatement("update Problem set Problem_status = ? where complain_Id = ? AND Problem_engineerId = ?");
			
			pt.setString(1, statuString);
			pt.setInt(2, complainId);
			pt.setString(3, engineerId);
			int x = pt.executeUpdate();
			
			if(x>0) {
				
				PreparedStatement pk = conn.prepareStatement("select * from Problem where complain_Id = '"+complainId+"' ");
				ResultSet resultSet  = pk.executeQuery();
				while(resultSet.next()) {
					int AtcomplainId = resultSet.getInt("complain_Id");
					String Atproblem = resultSet.getString("Problem_Name");
					String Atcategory = resultSet.getString("Problem_category");
					String Atstatus = resultSet.getString("Problem_status");
					String AtengineerId = resultSet.getString("Problem_engineerId");
					
					PreparedStatement Attend = conn.prepareStatement("insert into AttendedProblem values(?,?,?,?,?)");
					
					Attend.setInt(1, AtcomplainId);
					Attend.setString(2, Atproblem);
					Attend.setString(3, Atcategory);
					Attend.setString(4, Atstatus);
					Attend.setString(5, AtengineerId);
					Attend.executeUpdate();
					
				}
				
				
				
				
				meString = "Status upadated for "+ complainId+ "Problem";
				System.out.println(meString);
			}else {
				System.out.println("Problem doesn't exits with "+complainId);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return meString;
	}

	@Override
	public List<AttendedProblem> getAttendedProblems(String engineerID) {
		List<AttendedProblem> At1 = new ArrayList<>() ;
		try(Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("select * from AttendedProblem where AttendedProblem_engineerId = '"+engineerID+"' " );
			
			ResultSet rSet = pt.executeQuery();
			
			while(rSet.next()) {
				int complainId = rSet.getInt("complainId");
				String problem = rSet.getString("AttendedProblem_Name");
				String category = rSet.getString("AttendedProblem_category");
				String status = rSet.getString("AttendedProblem_status");
				String engineerId = rSet.getString("AttendedProblem_engineerId");
				
				
				AttendedProblem prb = new AttendedProblem(complainId,problem,category,status,engineerId);
				At1.add(prb);
				
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return At1;
	}

	@Override
	public String ChangePassword(String Email, String oldPassword, String newPassword) {
String messaString = "";
		
		try(Connection conn = DBUtil.provideconnection()) {
			
			PreparedStatement pt = conn.prepareStatement("update Engineer set Engineer_password = ? where Engineer_username = ? AND Engineer_password = ?");
			pt.setString(1, newPassword);
			pt.setString(2, Email);
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
