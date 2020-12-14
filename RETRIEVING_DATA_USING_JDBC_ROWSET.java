import java.sql.*;
import oracle.jdbc.rowset.OracleJDBCRowSet;


class RETRIEVING_DATA_USING_JDBC_ROWSET
{
	public static void main(String[] args) 
	{
	

	

	try(OracleJDBCRowSet jrowset=new OracleJDBCRowSet())
	{
		jrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		jrowset.setUsername("MANAGER");
		jrowset.setPassword("SYSTEM");

		jrowset.setCommand("SELECT SNO,SNAME,SADD,SAVG FROM STUDENT");

		jrowset.execute();

		while (jrowset.next())
		{
			System.out.println(jrowset.getString(1)+"  "+jrowset.getString(2)+"  "+jrowset.getString(3)+"  "+jrowset.getString(4));
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
