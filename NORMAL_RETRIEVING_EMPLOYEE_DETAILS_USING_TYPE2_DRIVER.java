
import java.sql.*;





import java.sql.*;
class NORMAL_RETRIEVING_EMPLOYEE_DETAILS_USING_TYPE2_DRIVER 
{
	public static void main(String[] args) throws Exception
	{
	oracle.jdbc.driver.OracleDriver d=new oracle.jdbc.driver.OracleDriver();

	DriverManager.registerDriver(d);

	Connection con=DriverManager.getConnection("jdbc:oracle:oci8:@xe","MANAGER","SYSTEM");

Statement st=con.createStatement();

ResultSet rs=st.executeQuery("SELECT ENAME,SAL,JOB,DEPTNO FROM EMP");
 

 while(rs.next()){  
	System.out.println(rs.getString(1) +"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
 }

 rs.close();
 st.close();
 con.close();
	}
}
