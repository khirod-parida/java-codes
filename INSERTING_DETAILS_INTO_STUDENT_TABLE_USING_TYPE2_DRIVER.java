import java.sql.*;
import java.util.Scanner;


class INSERTING_DETAILS_INTO_COLLEGE_REGISTER_USING_TYPE2_DRIVER_IN_MYSQL
{
	public static void main(String[] args) 
	{
		Scanner sc=null;

		String sname=null;
		String sadd=null;
		float savg =0.0f;

		com.mysql.cj.jdbc.Driver d=null;
		Connection con =null;
		Statement st=null;
		int count=0;

		String query=null;


		try
		{
			sc=new Scanner(System.in);

			if (sc!=null)
			{
				System.out.print("sname:");
				sname=sc.next();

				System.out.print("sadd:");
				sadd=sc.next();

				System.out.print("savg:");
				savg=sc.nextFloat();

			}

			d=new com.mysql.cj.jdbc.Driver();

			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:mysql:///khiroddb5","root","root");
			}

			if (con!=null)
			{
				st=con.createStatement();
			}
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";

			query="INSERT INTO COLLEGE_STUDENT_DETAILS(SNAME,SADD,SAVG) VALUES ("+sname+","+sadd+","+savg+")";

			if (st!=null)
			count=st.executeUpdate(query);

			if (count==0)
			System.out.println("record not inserted");
			
			else
				System.out.println("records inserted");
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
			catch (SQLException se )
			{
				se.printStackTrace();
			}
			try
			{
				if (con!=null)
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
