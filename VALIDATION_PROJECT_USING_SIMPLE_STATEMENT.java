import java.sql.*;
import java.util.Scanner;

class VALIDATION_PROJECT_USING_SIMPLE_STATEMENT
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
        String s1=null;
		String s2=null;
		oracle.jdbc.driver.OracleDriver d=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs= null;
		String query=null;
		int count=0;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("sid:");
				s1=sc.next();
				System.out.print("spass:");
				s2=sc.next();

			}
			d=new oracle.jdbc.driver.OracleDriver();
			if(d!=null){
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
			}
			if(con!=null)
				st=con.createStatement();

            s1="'"+s1+"'";
			s2="'"+s2+"'";
			query="SELECT COUNT(*) FROM STUDENT1 WHERE SID="+s1+" AND SPASS="+s2;


			if(st!=null)
				rs=st.executeQuery(query);

			if(rs.next())
				count=rs.getInt(1);


			if(count==1)
				System.out.println("valid credential");
			else
				System.out.println("invalid credential");







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
