import java.sql.*;

class RETRIEVING_STUDENT_DETAILS_USING_MYSQL_DATABASE
{
	public static void main(String[] args)throws Exception 
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(d);

		Connection con =DriverManager.getConnection("jdbc:mysql:///khiroddb","root","root");

		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT *FROM STUDENT");
while(rs.next()!= false){
	System.out.println(rs.getString(1)+"  " + rs.getString(2)+"  " + rs.getString(3));
}

		if(con==null){
			System.out.println("connection not established");
		}
		else{
			System.out.println("connection is established");
			
		}


	}
}
