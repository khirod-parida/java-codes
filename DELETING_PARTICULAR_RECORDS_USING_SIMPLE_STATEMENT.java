import java.sql.*;
import java.util.Scanner;

class DELETING_PARTICULAR_RECORDS_USING_SIMPLE_SATEMENT 
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		String s=null;
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
				System.out.print("SADD:");
				s=sc.nextLine();
				}
				d=new oracle.jdbc.driver.OracleDriver();
				if (d!=null)
				{
					DriverManager.registerDriver(d);

					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
					
				}
				if (con!=null)
				st=con.createStatement();

				
// DELETE FROM STUDENT WHERE SADD='NEW YORK'
                s="'"+s+"'";
				

				query="DELETE FROM STUDENT WHERE SADD="+s;
				System.out.println(query);
				if (st!=null){
				 count=st.executeUpdate(query);
				 System.out.println(count);
				}
				
				if (count==1)
				System.out.println(count+" student records deleted");
				else
					System.out.println(" sudents records not found");


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
				if (st!=null)
				{
					st.close();

				}
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
				if (sc!=null)
				{
					sc.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}
}
