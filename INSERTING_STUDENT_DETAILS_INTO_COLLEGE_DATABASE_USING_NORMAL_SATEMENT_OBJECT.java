
import java.sql.*;
import java.util.Scanner;

class INSERTING_STUDENT_DETAILS_INTO_COLLEGE_DATABASE_USING_NORMAL_STATEMENT_OBJECT
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		float avg=0.0f;


		com.mysql.cj.jdbc.Driver d=null;
		Connection con=null;
		Statement st=null;
		int count=0;

		try
		{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.print("enter sno:");
				 sno=sc.nextInt();
				System.out.print("enter sname:");
			    sname=sc.next();
				System.out.print("enter sadd:");
				sadd=sc.next();
				System.out.print("enter avg:");
				avg=sc.nextFloat();
			}

			d=new com.mysql.cj.jdbc.Driver();
			if(d!=null){
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:mysql:///khiroddb1","root","root");
			}

			if(con!=null)
				st=con.createStatement();

			sname="'"+sname+"'";
			sadd="'"+sadd+"'";

			if(st!=null)
				count=st.executeUpdate("INSERT INTO STUDENT VALUES("+sno+","+sname+","+sadd+","+avg+")");


			if(count==0)
				System.out.println("records not inserted");
			else
				System.out.println(count+"records inserted");

				

		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		finally{
			try
			{
				if(st!=null)
					st.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(con!=null)
					con.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(sc!=null)
					sc.close();
				
			}
			catch (Exception e){
				e.printStackTrace();
			
			}
		
		}
		
	}
}
