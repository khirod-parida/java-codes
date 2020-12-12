
import java.sql.*;

class RETRIEVING_STUDENT_INFO_FROM_COLLEGE_DATABASE_USING_MYSQL
{
} 
{
	public static void main(String[] args) throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(d);

		Connection con=DriverManager.getConnection("jdbc:mysql:///khiroddb1","root","root");

		Statement st=con.createStatement();

		ResultSet rs=st.executeQuery("SELECT SNO,SNAME,SADD,AVG  FROM STUDENT");

		while(rs.next()!=false){
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));

		}


		if(con!=null)
			System.out.println("connection established");
		else
			System.out.println("not established");

	}
}
