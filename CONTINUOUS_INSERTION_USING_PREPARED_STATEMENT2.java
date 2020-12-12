import java.sql.*;
import java.util.Scanner;
class CONTINUOUS_INSERTION_USING_PREPARED_STATEMENT2
{
	private static String INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		float savg=0.0f;


		oracle.jdbc.driver.OracleDriver d=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count =0;
		try
		{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.print("sno:");
				sno=sc.nextInt();
				System.out.print("sname:");
				sname=sc.next();
				System.out.print("sadd:");
				sadd=sc.next();
				System.out.print("savg:");
				savg=sc.nextFloat();
			}
			d=new oracle.jdbc.driver.OracleDriver();
			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
			}

			if(con!=null)
				ps=con.prepareStatement(INSERT_QUERY);

			if(ps!=null)
				ps.setInt(1,sno);
			ps.setString(2,sname);
			ps.setString(3,sadd);
			ps.setFloat(4,savg);

			if(ps!=null)
				count=ps.executeUpdate();

			if(count==1)
				System.out.println(count+"Student data inserted");
			else
				System.out.println("student data not inserted");
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
