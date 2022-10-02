package mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuizResult {

	//static Connection con = null;
	//static PreparedStatement ps = null;
	//static ResultSet rs = null;
	//static Scanner scan = null;
	//static int option = 2;
	public static void result() throws SQLException {
		// Program to generate quiz result for the admin
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		Scanner scan = new Scanner(System.in);
		int option = 2;
		System.out.println("Do you want to get complete class result or single student result: ");
		System.out.println("Enter  1  to check individual student result");
		System.out.println("Enter  2  to check complete class student results");
		
		try {
			//Step 1: Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");//This is deprecated.i.e. cj
			//Step 2: Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root1234");
			// Step 3 : Prepare Statements
			
			option = scan.nextInt();
			if(option == 1) {
				System.out.println("Enter your roll number: ");
				int roll = scan.nextInt();
				ps = con.prepareStatement("select * from student_info where roll_num = ?");
				ps.setInt(1, roll);
				rs = ps.executeQuery();
				
			}
			else if (option == 2){
				ps = con.prepareStatement("select * from student_info order by marks desc");
				rs = ps.executeQuery();
			} else {
				System.out.println("You have entered wrong option, please try again...");
				System.exit(0);
			}
			while(rs.next()) {
				System.out.print("Student Roll Number: " + rs.getInt(1) + " | ");
				System.out.print("Name: " + rs.getString(2) + " | ");
				System.out.print("Marks: " + rs.getInt(3) + " | ");
				System.out.print("Grade: " + rs.getString(4) + " | ");
				System.out.println("Result: " + rs.getString(5) + "  ");
				System.out.println("===================================================================================");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//rs.close();
			//ps.close();
			//con.close(); 
			//scan.close();
		}

	}

}
