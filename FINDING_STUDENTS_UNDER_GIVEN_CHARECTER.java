import java.sql.*;
import java.util.Scanner;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.Statement;

class FINDING_STUDENT_DETAILS_FOR_GIVEN_CHARECTER
{
	public static void main(String[] args) 
	{
	 Scanner sc=null;
	 String s=null;

	 oracle.jdbc.driver.OracleDriver d=null;
	 Connection con=null;
	 Statement st=null;
	 String query;
	 ResultSet rs=null;

try
{
	sc=new Scanner(System.in);
	if(sc!=null){
		System.out.print("enter charecters:");
		s=sc.next();
	}


	d=new oracle.jdbc.driver.OracleDriver();
	if(d!=null)
		DriverManager.registerDriver(d);

	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
	if(con!=null)
		st=con.createStatement();
//SELECT ENAME,SAL,JOB FROM EMP WHERE ENAME LIKE('KH%');
query="SELECT *FROM EMP WHERE ENAME LIKE"+ s;

if(st!=null)
	rs=st.executeQuery(query);

if(rs!=null){
	if(rs.next())
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	else
		System.out.println("records not found");
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
