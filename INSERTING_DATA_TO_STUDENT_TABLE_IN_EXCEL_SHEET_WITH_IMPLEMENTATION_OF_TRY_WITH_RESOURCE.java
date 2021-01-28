import java.sql.*;
import java.util.Scanner;

class INSERTING_DATA_TO_STUDENT_TABLE_IN_EXCEL_SHEET_WITH_IMPLEMENTATION_OF_TRY_WITH_RESOURCE
{
	private static final String INSERTION_QUERY="INSERT INTO studentdb1.Sheet1(SNO,SNAME,SADD,SAVG) VALUES(?,?,?,?)";
	public static void main(String[] args) throws Exception
	{
		Scanner sc=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		float savg=0.0F;



    com.hxtt.sql.excel.ExcelDriver d= new com.hxtt.sql.excel.ExcelDriver();
	DriverManager.registerDriver(d);
	int count =0;

	try
	{
		sc=new Scanner(System.in);

		System.out.print("sno:");
		 sno=sc.nextInt();

		System.out.print("sname:");
		 sname=sc.next();

		System.out.print("sadd:");
		 sadd=sc.next();

		System.out.print("savg:");
		 savg=sc.nextFloat();

	
	}
	finally{
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
	
		
		try(Connection con=DriverManager.getConnection("jdbc:Excel:///D://excel data"))
		{
			try(PreparedStatement ps=con.prepareStatement(INSERTION_QUERY)){
				ps.setInt(1,sno);
				ps.setString(2,sname);
				ps.setString(3,sadd);
				ps.setFloat(4,savg);

			if(ps!=null)
				count=ps.executeUpdate();


			if(count==0)
				System.out.println("records not inserted");
			else
				System.out.println("records inserted");
			
			
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
