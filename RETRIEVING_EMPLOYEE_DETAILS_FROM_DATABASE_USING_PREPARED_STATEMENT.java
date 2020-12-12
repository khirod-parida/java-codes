
import java.sql.*;
import java.util.Scanner;

class RETRIEVING_EMPLOYEE_DETAILS_FROM_DATABASE_USING_PREPARED_STATEMENT
{
	private static final String EMPLOYEE_DETAILS="SELECT ENAME,SAL,JOB FROM EMP WHERE DEPTNO=?";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int dept=0;

		oracle.jdbc.driver.OracleDriver d=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("dept:");
				dept=sc.nextInt();
			}

			d=new oracle.jdbc.driver.OracleDriver();

			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
			}

			if(con!=null)
				ps=con.prepareStatement(EMPLOYEE_DETAILS);

			if(ps!=null){
				ps.setInt(1,dept);
			}

			if(ps!=null)
				rs=ps.executeQuery();

			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
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
				if (rs!=null)
				{
					rs.close();
				}
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
