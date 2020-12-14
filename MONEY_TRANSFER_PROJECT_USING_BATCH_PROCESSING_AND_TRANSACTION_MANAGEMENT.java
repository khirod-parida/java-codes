import java.sql.*;
import java.util.Scanner;


class MONEY_TRANSFER_PROJECT_USING_BATCH_PROCESSINF_AND_TRANSACTION_MANAGEMENT
 
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		int src_accno=0;
		int dest_accno=0;
		float balance=0.0F;


        oracle.jdbc.driver.OracleDriver d=null;
		Connection con=null;
		Statement st=null;
		boolean flag=false;
		int result[]=null;

		try
		{
			sc=new Scanner(System.in);
			if (sc!=null)
			{
				System.out.print("source account no:");
				src_accno=sc.nextInt();

				System.out.print("dest account no:");
				dest_accno=sc.nextInt();

				System.out.print("balance:");
				balance=sc.nextFloat();
			}

			d=new oracle.jdbc.driver.OracleDriver();
			if (d!=null)
			{
				DriverManager.registerDriver(d);
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
			}
			if (con!=null)
			{
				st=con.createStatement();
			}
 
			if (st!=null)
			{
				st.addBatch("UPDATE BANK SET AMOUNT=AMOUNT-"+balance+"WHERE ACCNO="+src_accno);

				st.addBatch("UPDATE BANK SET AMOUNT=AMOUNT+"+balance+"WHERE ACCNO="+dest_accno);
			}

				
			
			if(st!=null)
			  result=st.executeBatch();
			


					
					for (int i=0;i<result.length ;++i )
					{
						if (result[i]==0)
						{
							flag=true;
							break;
						}
					}

					
			
			
		}
		catch (SQLException se)
		{
			flag=true;
				se.printStackTrace();
		}
		catch(Exception e){
			flag=true;
			e.printStackTrace();
		}
		finally{
			try
			{
				if (flag==true)
				{
					con.rollback();
					System.out.println("transaction rollbacked:transaction failed");
				}
				else {
					con.commit();
					System.out.println("transaction commited:transaction successful");
				}
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(st!=null)
					st.close();
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
