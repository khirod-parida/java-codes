import java.sql.*;
import java.util.Scanner;


class INSERTION_PROJECT_USING_PREPARED_STATEMENT
{
	private static final String INSERT_QUERY="INSERT INTO EMPLOYEE VALUES(?,?,?,?)";
	public static void main(String[] args) 
	{
	Scanner sc=null;
	int eno=0;
	String ename=null;
	String eadd=null;
	float esal=0.0f;
	int count=0;

	oracle.jdbc.driver.OracleDriver d=null;
	Connection con=null;
	PreparedStatement ps=null;
	int result=0;
	

	try
	{
		sc=new Scanner(System.in);
		if (sc!=null)
		{
			System.out.print("enter no of employees:");
			count=sc.nextInt();
		}
		d=new oracle.jdbc.driver.OracleDriver();
		if (d!=null)
		{
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
		}
		if (con!=null)
		{
			ps=con.prepareStatement(INSERT_QUERY);
		}
		if (ps!=null&&sc!=null)
		{
			for (int i=1;i<=count ;i++ )
			{
				System.out.print("eno:");
					eno=sc.nextInt();
				System.out.print("ename:");
				ename=sc.next();
				System.out.print("eadd:");
				eadd=sc.next();
				System.out.print("esal:");
				esal=sc.nextFloat();

				if(ps!=null)
					ps.setInt(1,eno);
				ps.setString(2,ename);
				ps.setString(3,eadd);
				ps.setFloat(4,esal);

				result=ps.executeUpdate();

				if(result==0)
					System.out.println(i+"employee details  not entered");
				else
					System.out.println(i+"employee details entered");



			}
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
