package com.masai.useCases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.Employee_dao;
import com.masai.dao.Employee_daoImpl;
import com.masai.dao.Engineer_dao;
import com.masai.dao.Engineer_daoImpl;
import com.masai.dao.HOD_dao;
import com.masai.dao.HOD_daoImpl;
import com.masai.models.AttendedProblem;
import com.masai.models.Employee;
import com.masai.models.Engineer;
import com.masai.models.Problem;
public class Use_Cases {

	public static void main(String[] args) {
		System.out.println(" HOD Enter : 1");
		System.out.println(" Engineer  Enter : 2");
		System.out.println(" Employee  Enter : 3");
		
		Scanner scanner = new Scanner(System.in);
		int Query = scanner.nextInt();
		
		switch (Query){
		
		 case 1 : {
			
			System.out.print("Enter your Email : ");
			String Email = scanner.next();
			
			System.out.print("Enter your Password : ");
			String password = scanner.next();
			
			HOD_dao dao = new HOD_daoImpl();
			String result=dao.HOD_Login(Email, password);
			System.out.println(result);
			
			while(true) {
				
				System.out.println("=================================================================");
				System.out.println("LogOut : if you want to logout your account press : 0");
				System.out.println("Registraion : If you want to Register an Engineer to your System Enter --->  1");
				System.out.println("See Engineers : If you want to See all Engineers then Enter --->  2");
				System.out.println("Delete Engineer : If you want to Delete Particular Engineers then Enter --->  3");
				System.out.println("See All Problems : If you want to See all the Raised problems then Enter --->  4");
				System.out.println("Assign Problem : If you want to Assign an Engineers to a problem Enter --->  5");
				System.out.println("==================================================================");
				
				
				
				scanner.nextLine();
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==0) {
					System.out.println("Logout siccesfull...");
					break;
				}
				
				else {
				  switch (key) {
				    
					case 1: {
						
						System.out.print("Enter  name :");
						String name = scanner.nextLine();
						System.out.print("Enter  EmailEng :");
						String EmailEng = scanner.nextLine();
						System.out.print("Enter Password :");
						String Password = scanner.nextLine();
						System.out.print("Enter category :");
						String category = scanner.nextLine();
						
						
						Engineer e1=new Engineer(name,EmailEng,Password,category);
						
						HOD_dao h1 = new HOD_daoImpl();
						
						String result2=h1.RegisterNewEngineerByHod(e1);
				
						System.out.println(result2);
						
					    break;
						
					}
					case 2: {
						HOD_dao h1 = new HOD_daoImpl();
						List<Engineer> e1 = h1.List_of_all_Registered_Engineers();
						
						e1.forEach(s -> System.out.println(s));
						
						
						break;
						
						
					}
					case 3: {
						
						System.out.print("Enter EngineerId which you want to delete :");
						String Eid = scanner.nextLine();
						HOD_dao h1 = new HOD_daoImpl();
						h1.deleteengineerS(Eid);
					
						break;
						
					}
					case 4: {
						HOD_dao h1 = new HOD_daoImpl();
						List<Problem> p1 = h1.getProblembDetails();
						
						p1.forEach(r -> System.out.println(r));
						
						
						break;
						
						
					}
					case 5: {
						System.out.print("Enter EngineerId which you want to assgign : ");
						String engineerId = scanner.nextLine();
						System.out.print("Enter complainId : ");
						int complainid = scanner.nextInt();
						
						HOD_dao h1 = new HOD_daoImpl();
						String res=h1.AssignProblemToEngineer(complainid, engineerId);
						System.out.println(res);
						break;
					}
					default:
						System.out.println("Unexpected value: "+ key);
						//throw new IllegalArgumentException("Unexpected value: " + key);
					}
				}
				
			}
			break;
			
		}
		case 2 :{
			
			
            while(true) {
            	
            	System.out.println("==============================================");
        		System.out.println("For LogOut : Press - 0");
            	System.out.println("For Login Another account press = 6");
		
				System.out.println("for See Assigned problems : press -7");
				System.out.println("for Update status : press - 8");
				System.out.println("for see Attented problems : press - 9");
				System.out.println("For change their password : press - 10");
				System.out.println("==============================================");
				
				
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==0) {
					System.out.println("Logout succesfull..");
					break;
				}
				
				else {
				  switch (key) {
				    case 6:{
				    	System.out.print("Enter your Email : ");
						String Email = scanner.nextLine();
						
						System.out.print("Enter your Password : ");
						String password = scanner.nextLine();
						
						Engineer_dao ENG = new Engineer_daoImpl();
						ENG.LoginAsEngineer(Email, password);
				    	break;
				    }
					case 7: {
						
						System.out.print("Enter your engineerId : ");
						String engineerId = scanner.nextLine();
						Engineer_dao ENG = new Engineer_daoImpl();
						List<Problem> prList = ENG.GetAssignedProblems(engineerId);
						prList.forEach(e -> System.out.println(e));
					    break;
						
					}
					case 8: {
						
						System.out.print("Enter your EngineerId : ");
						String engineerId = scanner.nextLine();
						
						System.out.print("Enter your complainId : ");
						int complainId = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter Status which you want to set : ");
						String status = scanner.nextLine();
						
						Engineer_dao ENG = new Engineer_daoImpl();
						ENG.UpdateStatus(status, complainId , engineerId);
						
						break;
						
						
					}
					case 9: {
						
						System.out.print("Enter your engineerId : ");
						String engineerId = scanner.nextLine();
						Engineer_dao ENG = new Engineer_daoImpl();
						List<AttendedProblem> AtList = ENG.getAttendedProblems(engineerId);
						AtList.forEach(e -> System.out.println(e));
					    break;
						
						
					}
					case 10: {
						System.out.print("Enter your email whose password you want to change : ");
						String email = scanner.nextLine();
						System.out.print("Enter your Old Password : ");
						String oldPasssword = scanner.nextLine();
						System.out.print("Enter your New password : ");
						String newPassword = scanner.nextLine();
						
						Engineer_dao ENG = new Engineer_daoImpl();
						ENG.ChangePassword(email, oldPasssword, newPassword);
						
						
						break;
						
						
					}
					default:
						System.out.println("Unexpected value: "+ key);
					}
				}
				
			}
            break;
			 
		}
		case 3:{
			
			
            while(true) {
            	
            	System.out.println("==============================================");
            	System.out.println("For LogOut : Press - 0");
            	System.out.println("For Registration  press = 11");
            	System.out.println("For Login  account press = 12");
            	System.out.println("For Raise problem or complain press = 13");
            	System.out.println("For Problem Status press = 14");
            	System.out.println("Check complain History press = 15");
            	System.out.println("Change your password = 16");
				System.out.println("==============================================");
				
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==0) {
					
			       					
					System.out.println("Logout succesfull..");
					break;
				}
				
				else {
				  switch (key) {
				    case 11:{
				    	
						
						System.out.print("Enter your Name : ");
						String Name = scanner.nextLine();
						
						System.out.println("Enter you emailID");
                        String emailID = scanner.nextLine();
						
						System.out.print("Enter your Password : ");
						String password = scanner.nextLine();
						
						Employee_dao emp = new Employee_daoImpl();
						Employee emp1 =new Employee(Name,emailID,password);
						String res=emp.RegisterAsEmployee(emp1);
						System.out.println(res);
				    	break;
				    }
					case 12: {
						
						System.out.print("Enter your Email : ");
						String Email = scanner.nextLine();
						
						System.out.print("Enter your Password : ");
						String password = scanner.nextLine();
						
						Employee_dao emp = new Employee_daoImpl();
						String res=emp.LoginAsEmployee(Email, password);
						System.out.println(res);

				    	break;
						
					}
					case 13: {
						
						System.out.print("Enter your problemName : ");
						String problemName = scanner.nextLine();
						
						System.out.print("Enter your category : ");
						String category = scanner.nextLine();
						
						System.out.print("Enter your Status : ");
						String Status = scanner.nextLine();
						
						System.out.print("Enter your EmployeeID : ");
						String EmployeeID = scanner.nextLine();
						
						
						Employee_dao emp = new Employee_daoImpl();
						Problem pa=new Problem(problemName,category,Status,EmployeeID);
						String res=emp.raiseProblem(pa);
						System.out.println(res);
						break;
						
						
					}
					case 14: {
						
						System.out.print("Enter your EmployeeID : ");
						String  EmployeeID = scanner.nextLine();
						
						System.out.print("Enter your ComplainId : ");
						int ComplainId = scanner.nextInt();

						Employee_dao emp = new Employee_daoImpl();
						String res=emp.checkStatus(ComplainId,EmployeeID);
						System.out.println(res);
						break;
						
					}
					case 15: {
						System.out.println("Enter your EmployeeID :");
						String employeeID = scanner.nextLine();
						
						Employee_dao emp = new Employee_daoImpl();
						List<Problem> lstList=emp.ComplainHistory(employeeID);
						lstList.forEach(s->System.out.println(s));
						
						
						break;
						
						
					}
					case 16: {
						System.out.print("Enter your email whose password you want to change : ");
						String email = scanner.nextLine();
						System.out.print("Enter your Old Password : ");
						String oldPasssword = scanner.nextLine();
						System.out.print("Enter your New password : ");
						String newPassword = scanner.nextLine();
						
						Employee_dao emp = new Employee_daoImpl();
						String res=emp.changePassword(email,oldPasssword,newPassword);
						System.out.println(res);
					    break;
					}
					default:
						System.out.println("Unexpected value: "+ key);
					}
				}
				
			}
            break;
			 
		}
		
		
		
		default:
			System.out.println("Unexpected value: ");
			
		    }
				  
		
	  

     
	
	}
}			

 
		