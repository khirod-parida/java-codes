
import java.sql.*;
import java.util.Scanner;



class RETRIEVING_STUDENT_DETAILS_USING_PLSQL_PROCEDURES_USING_MYSQLDB 
{/*DELIMITER $$
USE `khiroddb3`$$
CREATE PROCEDURE `student_details` (in no int , out name varchar(20), out address varchar(20), out avg float )
BEGIN
select sname,sadd,avg into name, address, avg from student where sno=no;
END$$
*/
private static final String STUDENT_DETAILS_QUERY="{call student_details(?,?,?,?)}";
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int no=0;

		com.mysql.cj.jdbc.Driver d=null;
		Connection con=null;
		CallableStatement cs=null;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("no:");
				no=sc.nextInt();
			}

			d=new com.mysql.cj.jdbc.Driver();
			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:mysql:///khiroddb3","root","root");
			}
			if(con!=null)
				cs=con.prepareCall(STUDENT_DETAILS_QUERY);

			if(cs!=null){
				cs.registerOutParameter(2,Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.FLOAT);
			}

			if(cs!=null)
				cs.setInt(1,no);

			if(cs!=null)
				cs.execute();

			if (cs!=null)
			{
				System.out.println("name:"+cs.getString(2));
				System.out.println("address:"+cs.getString(3));
				System.out.println("avg:"+cs.getString(4));

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
