import java.sql.*;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;


class CREATING_CONNECTION_POOL_AND_FETCHING_DATA_USING_FETCHED_CONNECTION_OBJECT
{
	public static void main(String[] args) 
	{
		oracle.jdbc.pool.OracleConnectionPoolDataSource ds=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try
		{
			//creating connection pool......
			ds=new oracle.jdbc.pool.OracleConnectionPoolDataSource();

			ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			ds.setUser("MANAGER");
			ds.setPassword("SYSTEM");

            //fetching connection object from connection pool.....
			con=ds.getConnection();

			st=con.createStatement();

			rs=st.executeQuery("SELECT SNO,SNAME,SADD,SAVG FROM STUDENT");

			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			}
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try
			{
				if(rs!=null)
					rs.close();
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
		}
	}
}
