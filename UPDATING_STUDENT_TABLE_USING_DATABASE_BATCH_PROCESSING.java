import java.sql.*;


class UPDATING_STUDENT_TABLE_USING_DATABASE_BATCH_PROCESSING

{
	public static void main(String[] args)throws Exception 
	{
	oracle.jdbc.driver.OracleDriver d=new oracle.jdbc.driver.OracleDriver();
	DriverManager.registerDriver(d);
	try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM"))
	{
		if (con!=null)
		{
			try(Statement st=con.createStatement())
			{
				if (st!=null)
				{
					st.addBatch("INSERT INTO STUDENT VALUES (1003,'CAPY','MOHALI',43.6)");
					st.addBatch("INSERT INTO STUDENT VALUES (1004,'COORO','HUNGARY',87.5)");
					st.addBatch("UPDATE STUDENT SET SAVG=45 WHERE SNAME='KHIROD1'");
					st.addBatch("DELETE FROM STUDENT WHERE SNAME ='KHIROD1'");

					int result[]=st.executeBatch();

					int total=0;

					for (int i=0;i<result.length ;i++ )
					{
						 total=total+result[i];
					}
					System.out.println("no of records affected:" +total);
				}
				
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
	}
}
