
import java.sql.*;
import java.util.Scanner;



class CHECKING_STUDENTID_VALIDATIONS_USING_TYPE2_DRIVER_AND_PREPARED_STATEMENT
{
}
{
	private static final String VALIDATION_QUERY="SELECT COUNT(*) FROM STUDENTID WHERE USERNAME=? AND PASSWORD=?";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		String user=null;
		String pass=null;


		com.mysql.cj.jdbc.Driver d=null;
		Connection con =null;
		PreparedStatement ps=null;
		ResultSet rs=null;


		int count=0;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("user name:");
				user=sc.next();

				System.out.print("password:");
				pass=sc.next();
			}

			d=new com.mysql.cj.jdbc.Driver();

			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:mysql:///khiroddb5","root","root");
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
				while(rs.next())
					count=rs.getInt(1);

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
