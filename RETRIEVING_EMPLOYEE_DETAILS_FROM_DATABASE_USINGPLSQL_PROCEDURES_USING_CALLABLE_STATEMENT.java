
import java.sql.*;
import java.util.Scanner;



class RETRIEVING_EMPLOYEE_DETAILS_FROM_DATABASE_USINGPLSQL_PROCEDURES_USING_CALLABLE_STATEMENT
{
	
	public static String CALL_PROCEDURE_QUERY="{CALL GET_DETAILS(?,?,?,?)}";
	public static void main(String[] args) 
	{
	Scanner sc=null;
	int no=0;

	oracle.jdbc.driver.OracleDriver d=null;
	Connection con=null;
	CallableStatement cs=null;


	try
	{
		sc=new Scanner(System.in);
		if(sc!=null){
			System.out.print("no:");
			no=sc.nextInt();
		}

		d=new oracle.jdbc.driver.OracleDriver();

		if(d!=null){
			DriverManager.registerDriver(d);
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
		}
		if(con!=null)
			cs=con.prepareCall(CALL_PROCEDURE_QUERY);

		if(cs!=null){
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.FLOAT);
			cs.registerOutParameter(4,Types.VARCHAR);
			
		}

		if(cs!=null){
			cs.setInt(1,no);
		}

		if(cs!=null)
			cs.execute();



		if(cs!=null){
			System.out.print("employee name:"+cs.getString(2));
			System.out.println();
			System.out.print("employee sal:"+cs.getString(3));
			System.out.println();
			System.out.print("employee designation:"+cs.getString(4));
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
