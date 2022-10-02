package mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class QuizMain {

	public static void main(String[] args) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement stud_ps = null;
		Scanner sc = new Scanner(System.in);
		int marks = 0; String grade;
		String result; 
		
		try {
			//Step 1: Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");//This is deprecated.i.e. cj
			//Step 2: Establish Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root1234");
			// Step 3 : Prepare Statements
			ps = con.prepareStatement("select * from question", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);			
			//ps = con.prepareStatement("select * from question", ResultSet.TYPE_SCROLL_INSENSITIVE);
			
			// Input student Credentials
			stud_ps = con.prepareStatement("insert into student_info (roll_num, name, marks, grade, result) values (?, ?, ?, ?, ?)");
			System.out.println("Enter you roll no. : ");
			int roll_num = sc.nextInt();
			System.out.println("Enter you name : ");
			String name = sc.next();
			
			ResultSet rs = ps.executeQuery();
			
			LinkedHashSet<Integer> lhs = RandQues.linkedHashSet();
			Iterator<Integer> itr = lhs.iterator();
			//int arr[] = lhs.toArray(new int[0]);
			
			
			int i = 0;
			while(itr.hasNext()) { //
				//System.out.println(); //Column 1 Row 1
				i = itr.next();
				System.out.println(i);
				
				rs.absolute(i);
				System.out.println("Que : " + rs.getString(2));
				System.out.println("a : " + rs.getString(3));
				System.out.println("b : " + rs.getString(4));
				System.out.println("c : " + rs.getString(5));
				System.out.println("d : " + rs.getString(6));
				char answer = rs.getString(7).charAt(0);
				System.out.println("Enter your option : "); //abracadabra apple
				String stud_ans = sc.next();
				boolean flag = true;
				while (flag) {
					if (stud_ans.length()==1) {
						if (stud_ans.charAt(0) == 'a' || stud_ans.charAt(0) == 'b' || stud_ans.charAt(0) == 'c' || stud_ans.charAt(0) == 'd'){
							if (answer == stud_ans.charAt(0)) {
								marks++;
							}
							flag = false;}
					} else {
						System.out.println("You've entered an invalid answer. \nPlease select Option a, b, c or d");
						stud_ans = sc.next();
					}
				}
			}
			
			System.out.println("Your total marks out of 10 is : " + marks);
			
			// Set credentials in SQL
			stud_ps.setInt(1, roll_num);
			stud_ps.setString(2, name);
			stud_ps.setInt(3, marks);
			if (marks>= 8) {
				grade ="A"; result = "Distinction";
			} else if (marks >= 6  && marks <8) {
				grade ="B"; result = "FirstClass";
			} else if (marks == 5) {
				grade ="C"; result = "SecondClass";
			}else {
				grade ="D"; result = "Fail";
			}
			stud_ps.setString(4, grade);
			stud_ps.setString(5, result);
			stud_ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stud_ps.close();
			ps.close();
			con.close();
			//sc.close();
		}
		
		QuizResult.result();
	}

}
