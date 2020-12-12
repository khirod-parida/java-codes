
import java.sql.*;
import java.util.Scanner;

class INSERTING_STUDENT_DETAILS_INTO_COLLEGE_DATABASE_USING_PREPARED_SATEMENT
{
	public static String INSERT_QUERY="INSERT INTO STUDENT(SNAME,SADD,AVG) VALUES(?,?,?)";
	public static void main(String[] args) 
	{
	Scanner sc=null;
	int sno=0;
	String sname=null;
	String sadd=null;
	float avg=0.0f;

	com.mysql.cj.jdbc.Driver d=null;
	Connection con=null;
	PreparedStatement ps=null;
	int result=0;
	int count=0;

	try
	{
		sc=new Scanner(System.in);
		
		d=new com.mysql.cj.jdbc.Driver();

		if(d!=null){
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:mysql:///khiroddb3","root","root");
		}

		if(con!=null)
			ps=con.prepareStatement(INSERT_QUERY);

		if(ps!=null&&sc!=null){

			System.out.print("student count:");
			count=sc.nextInt();
			for(int i=1;i<=count;i++){
			System.out.print("sname:");
			sname=sc.next();
			System.out.print("sadd:");
			sadd=sc.next();
			System.out.print("avg:");
			avg=sc.nextFloat();

			if (ps!=null)
			{
				ps.setString(1,sname);
				ps.setString(2,sadd);
				ps.setFloat(3,avg);
			}

			if(ps!=null)
				result=ps.executeUpdate();
			
			if(result==0)
				System.out.println("records not inserted");
			else
				System.out.println(i+ " "+ "records inserted");
			}
		}
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
			if(ps!=null)
				ps.close();
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	}
}
