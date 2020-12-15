import java.sql.*;
import oracle.jdbc.rowset.OracleWebRowSet;
import java.io.*;


class CONVERTING_ROWSET_DATA_TO_XML_FILE_FORMAT_TO_SEND_ON_NETWORK
{
	public static void main(String[] args) 
	{
		try(oracle.jdbc.rowset.OracleWebRowSet wr=new oracle.jdbc.rowset.OracleWebRowSet())
		{
			wr.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			wr.setUsername("MANAGER");
				wr.setPassword("SYSTEM");

			wr.setCommand("SELECT SNO,SNAME,SADD,SAVG FROM STUDENT ");

			wr.execute();

			while (wr.next())
			{
				System.out.println(wr.getString(1)+"  "+wr.getString(2)+"  "+wr.getString(3)+ "  "+wr.getString(4));
			}
			
			System.out.println("converting rowset data to xml file :");

			Writer write= new FileWriter("STUDENT_INFO.XML");

			wr.writeXml(write);

			System.out.println("writtting rowset data to xml:");

			wr.writeXml(System.out);
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
