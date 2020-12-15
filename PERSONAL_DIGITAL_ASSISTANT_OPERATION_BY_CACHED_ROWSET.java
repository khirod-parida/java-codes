
import java.sql.*;

import oracle.jdbc.rowset.OracleCachedRowSet;

class PERSONAL_DIGITAL_ASSISTANT_OPERATION_BY_CACHED_ROWSET 
{
	public static void main(String[] args) 
	{
		try(oracle.jdbc.rowset.OracleCachedRowSet cr=new  oracle.jdbc.rowset.OracleCachedRowSet())
		{
			cr.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			cr.setUsername("MANAGER");
			cr.setPassword("SYSTEM");

			cr.setCommand("SELECT SNO,SNAME,SADD,SAVG FROM STUDENT");

			
			cr.execute();
			
			

			while (cr.next())
			{
				System.out.println(cr.getString(1)+"  "+cr.getString(2)+"  "+cr.getString(3)+"  "+cr.getString(4));
			}

			System.out.println("------------DATABASE-STOPPED---------");
			Thread.sleep(40000);


              cr.absolute(3);
              cr.updateString(3,"hongkong");
              cr.updateRow();

              

              System.out.println("---------------DATABASE-STARTED----------");
Thread.sleep(40000 );
cr.acceptChanges();
              while (cr.next())
                            {
	              System.out.println(cr.getString(1)+"  "+cr.getString(2)+" "+cr.getString(3)+ "  "+cr.getString(4));
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
