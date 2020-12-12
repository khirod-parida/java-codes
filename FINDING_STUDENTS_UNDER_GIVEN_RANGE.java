import java.sql.*;
import java.util.Scanner;


class FINDING_STUDENTS_UNDER_GIVEN_RANGE
{
	public static void main(String[] args)throws Exception 
	{
	Scanner sc=new Scanner(System.in);
	System.out.print("enter starting range:");
	int range1= sc.nextInt();

	System.out.println("enter ending range:");
	int range2=sc.nextInt();

	oracle.jdbc.driver.OracleDriver d= new oracle.jdbc.driver.OracleDriver();

	DriverManager.registerDriver(d);

	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");

	Statement st=con.createStatement();

	String query="SELECT*FROM STUDENT WHERE SNO>="+range1+"And SNO<="+range2;

	System.out.println(query);
	ResultSet rs=st.executeQuery(query);

	boolean b=false;
	while(rs.next()){
		b=true;
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
	}

	if(b==false){
		System.out.println("records  not found");
	}
	else{
		System.out.println("SELECT *FROM STUDENT WHERE SNO>="+ range1+"AND SNO<="+ range2);
	}

	rs.close();
	st.close();
con.close();
}
}

