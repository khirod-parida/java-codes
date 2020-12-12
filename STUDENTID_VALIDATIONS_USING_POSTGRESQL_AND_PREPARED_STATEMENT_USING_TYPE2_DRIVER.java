import java.sql.*;
import java.util.Scanner;



class STUDENTID_VALIDATIONS_USING_POSTGRESQL_AND_PREPARED_STATEMENT_USING_TYPE2_DRIVER
{
	private static final String VALIDATION_QUERY="SELECT COUNT(*) FROM STUDENTID_DETAILS  WHERE USERNAME=? AND PASSWORD=?";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		String user=null;
		String pass=null;

		org.postgresql.Driver d=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;


		int count =0;

		try
		{
			sc=new Scanner(System.in);
           if(sc!=null){
			System.out.print("user name:");
			user=sc.next();

			System.out.print("pass:");
			pass=sc.next();
		   }

		   d=new org.postgresql.Driver();

		   if (d!=null)
		   {
			   DriverManager.registerDriver(d);
			   con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/khiroddb1","postgres","root");
		   }

		   if (con!=null)
		   {
			   ps=con.prepareStatement(VALIDATION_QUERY);
		   }

		   if (ps!=null)
		   {
			   ps.setString(1,user);
			   ps.setString(2,pass);
		   }

		   if (ps!=null)
		   {
			   rs=ps.executeQuery();
		   }

		   while(rs.next()){
			count=rs.getInt(1);
		   }
			
			if (count==0)
			System.out.println("invalid credentials");

			else
				System.out.println("valid credentials");
		
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
				if(rs!=null)
					rs.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
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
