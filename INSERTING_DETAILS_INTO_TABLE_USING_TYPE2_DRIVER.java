import java.sql.*;
import java.util.Scanner;


class INSERTING_DETAILS_INTO_TABLE_USING_TYPE2_DRIVER 
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int sno=0;

		String sname=null;
		String sadd=null;
		float savg=0.0f;


		oracle.jdbc.driver.OracleDriver d=null;
		Connection con=null;
		Statement st=null;

		int count=0;
		String query=null;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("sno:");
				sno=sc.nextInt();

				System.out.print("sname:");
				sname=sc.next();

				System.out.print("sadd:");
				sadd=sc.next();

				System.out.print("savg:");
				savg=sc.nextFloat();
			}

			d=new oracle.jdbc.driver.OracleDriver();

			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:oracle:oci8:@xe","MANAGER","SYSTEM");
			}

			if (con!=null)
			{
				st=con.createStatement();
			}
			sname="'"+sname+"'";
			sadd="'"+sadd+"'";


			query="INSERT INTO STUDENT VALUES("+sno+","+sname+","+sadd+","+savg+")";
			if (st!=null)
			{
				count=st.executeUpdate(query);
			}

			if(count==0)
				System.out.println("records not inserted");

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
