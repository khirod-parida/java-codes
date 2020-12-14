import java.sql.*;


class RETRIEVING_STUDENT_DATA_FROM_DATABASE_USING_EXCEL_SHEET_AS_DATABASE_IMPLEMENTING_TRY_WITH_RESOURCE
{
	private static final String RETRIEVING_QUERY="SELECT * FROM studentdb.Sheet1";
	public static void main(String[] args) throws Exception 
	{
		com.hxtt.sql.excel.ExcelDriver d=new com.hxtt.sql.excel.ExcelDriver();
		DriverManager.registerDriver(d);
		try(Connection con=DriverManager.getConnection("jdbc:Excel:///D://excel data"))
		{
			try(PreparedStatement ps=con.prepareStatement(RETRIEVING_QUERY)){
				try(ResultSet rs=ps.executeQuery()){
					while (rs.next())
					{
						System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
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
