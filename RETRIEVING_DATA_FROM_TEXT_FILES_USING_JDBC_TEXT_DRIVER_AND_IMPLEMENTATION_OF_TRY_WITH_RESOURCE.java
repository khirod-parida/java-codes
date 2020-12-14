
import java.sql.*;

class RETRIEVING_DATA_FROM_TEXT_FILES_USING_JDBC_TEXT_DRIVER_AND_IMPLENTATION_OF_TRY_WITH_RESOURCE
{
	private static final String RETRIEVING_QUERY="SELECT * FROM file1.csv ";
	public static void main(String[] args) throws Exception 
	{
		com.hxtt.sql.text.TextDriver d=new com.hxtt.sql.text.TextDriver();
		DriverManager.registerDriver(d);
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///D://excel data")){
			try(PreparedStatement ps=con.prepareStatement(RETRIEVING_QUERY)){
				try(ResultSet rs=ps.executeQuery()){
					while (rs.next())
					{
						System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
					}
				}
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
