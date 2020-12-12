import java.sql.*;
import java.util.Scanner;


class CONTINUOUS_INSERTION_PROJECT_USING_PREPARED_STATEMENT
{
	private static final String INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		float savg=0.0f;
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
				System.out.print("enter student count:");
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

			if(ps!=null && sc!=null){
				for (int i=1;i<count ;i++ )
				{
					System.out.print("sno:");
					sno=sc.nextInt();
					System.out.print("sname:");
					sname=sc.next();
					System.out.print("sadd:");
					sadd=sc.next();
					System.out.print("savg:");
					savg=sc.nextFloat();
				
			
			if(ps!=null){
				ps.setInt(1,sno);
				ps.setString(2,sname);
				ps.setString(3,sadd);
				ps.setFloat(4,savg);
			}
			
				result =ps.executeUpdate();
				System.out.println(result);
		

			if (result==0)
				System.out.println(i +"student records not inserted");
			else
				System.out.println(i+"student records inserted");


				}
			}



			

		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
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
