
import java.sql.*;
import java.util.Scanner;


class INSERTING_STUDENT_DETAILS_INTO_COLLEGE_DATABASE_USING_POSTGRESQL_AND_PREPARED_SATEMENT
{
	public static String INSERT_QUERY="INSERT INTO STUDENT VALUES(nextval('sno_seq'),?,?,?)";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		float avg=0.0f;

		org.postgresql.Driver d=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		int result=0;
		

		try
		{
			sc=new Scanner(System.in);
			
			d= new org.postgresql.Driver();
			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/khiroddb","postgres","root");
			}

			if(con!=null)
				ps=con.prepareStatement(INSERT_QUERY);

			
			

			if(ps!=null&&sc!=null)
			{
				System.out.print("enter student count:");
				count=sc.nextInt();

				for (int i=1;i<=count ;i++ )
				{
					System.out.print("sname:");
						sname=sc.next();
					System.out.print("sadd:");
					sadd=sc.next();
					System.out.print("avg:");
					avg=sc.nextFloat();
					
		if (ps!=null)
			{
				ps.setString(1,sname);
				ps.setString(2,sadd);
				ps.setFloat(3,avg);
			}

				
				if (ps!=null)
		         result=ps.executeUpdate();

				if (result==0)
				System.out.println("data not updated");
				else
					System.out.println(i+"data updated");
				
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
