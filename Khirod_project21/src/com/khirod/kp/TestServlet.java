package com.khirod.kp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	private static final String  VALIDATION_PROCESS="SELECT COUNT(*) FROM EMPLOYEEID WHERE EMPID=? AND EMPPASS=?";
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		String sname=req.getParameter("name");
		
		String spass=req.getParameter("pass");
		
		int result=0;
		
		oracle.jdbc.driver.OracleDriver d=null;
		
		Connection con=null;
		
		ResultSet rs=null;
		
		PreparedStatement ps=null;
		
		try {
			
			d= new oracle.jdbc.driver.OracleDriver();
			
			DriverManager.registerDriver(d);
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MANAGER","SYSTEM");
			
			if(con!=null)
				ps=con.prepareStatement( VALIDATION_PROCESS);
			
			if(ps!=null) {
				ps.setString(1,sname);
				ps.setString(2, spass);
			}
			
			if(ps!=null)
				rs=ps.executeQuery();
			
			if(rs!=null) {
				if(rs.next())
					result=rs.getInt(1);
			}
			if(result==1)
				 pw.println("<h1 style='color:red;text-align:center'>Valid User</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Invalid User</h1>");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		pw.println("<br><a href='home.html'>home</a>");
		pw.close();
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
}
}
