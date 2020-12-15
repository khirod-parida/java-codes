
import java.sql.*;
import oracle.jdbc.rowset.OracleJDBCRowSet;


class RETRIEVING_FIRST_4_RECORDS_FROM_THE_DATABASE
{
	public static void main(String[] args) 
	{
		try(oracle.jdbc.rowset.OracleJDBCRowSet d=new  oracle.jdbc.rowset.OracleJDBCRowSet())
		{
			d.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			d.setUsername("MANAGER");
			d.setPassword("SYSTEM");

		d.setCommand("SELECT SNO,SNAME,SADD,SAVG FROM STUDENT ");
 d.setMaxRows(3);
 d.execute();


		while (d.next())
		{
			System.out.println(d.getString(1)+"  "+d.getString(2)+"  "+d.getString(3)+ "  " +d.getString(4));
		}
			
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
