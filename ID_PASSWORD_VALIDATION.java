import java.sql.*;
import java.util.Scanner;



class ID_PASSWORD_VALIDATION
{
	public static void main(String[] args) 
	{
	
	Scanner sc=null;
	String id=null;
	String pass=null;

	oracle.jdbc.driver.OracleDriver d=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	String query=null;

	int count=0;


try
{
	sc=new Scanner(System.in);
	if (sc!=null)
	{
		System.out.print("enter id:");
		id=sc.nextLine();

		System.out.print("enter pass:");
		pass=sc.next();

	}

	d=new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(d);

if (d!=null)
{
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
}
if (con!=null)
{
	st=con.createStatement();
}

id="'"+id+"'";
pass="'"+pass+"'";

// SELECT COUNT(*) FROM EMPLOYEEID WHERE EMPID='KHIROD' AND EMPPASS='PARIDA'
query="SELECT COUNT(*) FROM EMPLOYEEID WHERE EMPID="+id+ "AND EMPPASS="+pass;
System.out.println(query);
if(st!=null){
	rs=st.executeQuery(query);
}
if (rs!=null)
{
rs.next();
count=rs.getInt("count(*)");
}
if (count==1)
System.out.println("valid credential");

else 
	System.out.println("invalid credential");


}
catch (SQLException se )
{
	se.printStackTrace();
}
catch(Exception e){
	e.printStackTrace();
}
finally {
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
