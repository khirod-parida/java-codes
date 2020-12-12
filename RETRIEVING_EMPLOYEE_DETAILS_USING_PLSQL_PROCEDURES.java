import java.sql.*;
import java.util.Scanner;


class RETRIEVING_EMPLOYEE_DETAILS_USING_PL/SQL_PROCEDURES
{ /* CREATE OR REPLACE PROCEDURE EMPLOYEE_DETAILS(DEPT IN   NUMBER,NAME OUT  VARCHAR2, SAL OUT NUMBER,DEG OUT  VARCHAR2)
  2  AS
  3  BEGIN
  4  SELECT ENAME, E.SAL,JOB INTO NAME,SAL,DEG FROM EMP E WHERE DEPTNO=DEPT;
  5* END;
SQL> /
*/

	private static final String RETRIEVING_EMPLYOEE_DETAILS="{CALL EMPLOYEE_DETAILS(?)}";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int dept=0;

		oracle.jdbc.driver.OracleDriver d=null;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("deptno:");
					dept=sc.nextInt();
			}

			d=new oracle.jdbc.driver.OracleDriver();

			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
			}

			if (con!=null)
			{
				cs=con.prepareCall(RETRIEVING_EMPLYOEE_DETAILS);
			}

			if (cs!=null)
			{
				cs.registerOutParameter(2,Types.VARCHAR);
				cs.registerOutParameter(3,Types.INTEGER);
				cs.registerOutParameter(4,Types.VARCHAR);
			}

			if (cs!=null)
			{
				cs.setInt(1,dept);
			}

			if (cs!=null)
			{
				cs.execute();
			}

			while (cs!=null)
			{
				System.out.println(cs.getString(1)+" "+cs.getString(2)+"  "+cs.getString(3));
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
				if(rs!=null)
					rs.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(cs!=null)
					cs.close();
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
