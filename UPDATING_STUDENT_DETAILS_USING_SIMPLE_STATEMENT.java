import java.sql.*;
import java.util.Scanner;

class UPDATING_STUDENT_DETAILS_USING_SIMPLE_SATEMENT
{
	public static void main(String[] args) 
	{
	Scanner sc=null;
    String s1=null;
	String s2=null;
	oracle.jdbc.driver.OracleDriver d=null;
	Connection con=null;
	Statement st=null;
	String query=null;
	int count=0;

	try
	{
		sc=new Scanner(System.in);
		if (sc!=null)
		{
			System.out.print("SADD1:");
			s1=sc.next();
			System.out.println("SADD2:");
			s2=sc.next();
		}
		d=new oracle.jdbc.driver.OracleDriver();
		if (d!=null)
		{
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
		}
		if (con!=null)
		st=con.createStatement();

		s1="'"+s1+"'";
		s2="'"+s2+"'";

		query="UPDATE STUDENT SET SADD="+s1+ "WHERE SADD="+s2;

		if(con!=null)
			count=st.executeUpdate(query);

		if(count==1)
			System.out.println(count+"student data updated");
		else
			System.out.println("error:student data not updated");

		
	}
	catch (SQLException  se)
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
			if (con!=null)
			{
				con.close();
			}
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}












	}
}
