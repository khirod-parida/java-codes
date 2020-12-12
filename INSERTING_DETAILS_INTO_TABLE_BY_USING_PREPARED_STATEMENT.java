
import java.sql.*;
import java.util.Scanner;



class INSERTING_DETAILS_INTO_TABLE_BY_USING_PREPARED_STATEMENT
{
	public static final String INSERTION_QUERY="INSERT INTO COLLEGE_STUDENT_DETAILS (SNAME,SADD,SAVG) VALUES(?,?,?)";
	public static void main(String[] args) 
	{
		Scanner sc=null;

		String sname=null;
		String sadd=null;
		float savg=0.0f;

		

		com.mysql.cj.jdbc.Driver d=null;
		Connection con=null;

		PreparedStatement ps=null;

		int count=0;
		int result=0;


		try
		{
			sc=new Scanner(System.in);
		
			

			d=new com.mysql.cj.jdbc.Driver();

			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:mysql:///khiroddb5","root","root");
			}

			if (con!=null)
			{
				ps=con.prepareStatement(INSERTION_QUERY);
			}

			
			if (sc!=null && ps!=null)
			{
				System.out.print("count:");
				count=sc.nextInt();
				for (int i=1;i<=count ;i++ )
				{
					System.out.print("sname:");
					sname=sc.next();

					System.out.print("sadd:");
					sadd=sc.next();

					System.out.print("savg:");
					savg=sc.nextFloat();

					if (sc!=null)
					{
						ps.setString(1,sname);
						ps.setString(2,sadd);
						ps.setFloat(3,savg);
						
						}

						if (ps!=null)
						{
							result=ps.executeUpdate();
						}

						if(result==0)
							System.out.println("student records not inserted");
						else
							System.out.println(i + "tsudent records inserted");
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
				if (sc!=null)
					sc.close();
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		

	}
}
