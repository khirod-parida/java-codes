
import java.sql.*;
import java.util.Scanner;

class CHECKING_VALIDATIONS_OF_STUDENTS_FROM_DATABASE_USING_PREPARED_STATEMENT_AND_POSTGRESQL
{
	public static String VALIDATION_QUERY="SELECT COUNT(*) FROM STUDENTID WHERE SID=? AND SPASS=?";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		String sid=null;
		String spass=null;

		org.postgresql.Driver d=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 int count=0;

		 try
		 {
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("sid:");
				sid=sc.next();
				System.out.print("spass:");
				spass=sc.next();
			}

			d=new org.postgresql.Driver();
			if(d!=null){
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/khiroddb","postgres","root");
			}

			if(con!=null)
				ps=con.prepareStatement(VALIDATION_QUERY);

			if(ps!=null){
				ps.setString(1,sid);
				ps.setString(2,spass);
			}

             if(ps!=null){
				rs=ps.executeQuery();
		
             }

			 if(rs.next())
				 count=rs.getInt(1);


			if(count==1)
				System.out.println("valid credential");
			else
				System.out.println("invalid credential");

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
				if(ps!=null)
					ps.close();
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
