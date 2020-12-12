import java.sql.*;


class INSERTING_STUDENT_DETAILS_INTO_COLLEGE_DATABASE_USING_NORMAL_STATEMENT_AND_MYSQL
{
	public static void main(String[] args)throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();

		DriverManager.registerDriver(d);

		Connection con=DriverManager.getConnection("jdbc:mysql:///khiroddb1","root","root");

		Statement st=con.createStatement();

		int count=st.executeUpdate("INSERT INTO STUDENT VALUES(105,'MONALISHA','ODISHA',90)");

		if(count==0)
			System.out.println("records not inserted");
		else
			System.out.println("records inserted");

		if (con!=null)
		System.out.println("connection established");
		else
			System.out.println("not established");
		
	}
}
