package com.khirod.kp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	private static final String EMPLOYEE_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE ENAME=? AND EMPNO=?";
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		String sname=req.getParameter("name");
		
		String snum=req.getParameter("no");
		
		int num=0;
		
		oracle.jdbc.driver.OracleDriver d=null;
		
		Connection con=null;
		
		ResultSet rs=null;
		
		PreparedStatement ps=null;
		
		try {
			num=Integer.parseInt(snum);
			
			ServletConfig cg= getServletConfig();
			
			String driver=cg.getInitParameter("class");
			
			String url=cg.getInitParameter("url");
			
			String username=cg.getInitParameter("username");
			
			String password=cg.getInitParameter("password");
			
			
		Class.forName(driver);
		
		con=DriverManager.getConnection(url,username,password);
		
			if(con!=null)
				ps=con.prepareStatement(EMPLOYEE_DETAILS);
			
			if(ps!=null) {
				ps.setString(1, sname);
				ps.setInt(2, num);
			}
			
			if(ps!=null)
				rs=ps.executeQuery();
			
			if(rs!=null) {
				if(rs.next()) {
					pw.println("<h1 style='color:red;text-align:center'>Employee Details Are..</h1>");
					
					pw.println("<br><b>Employee Num:"+rs.getString(1)+"</b>");
					pw.println("<br><b>Employee Name:"+rs.getString(2)+"</b>");
					pw.println("<br><b>Employee Job:"+rs.getString(3)+"</b>");
					pw.println("<br><b>Employee Sal:"+rs.getString(4)+"</b>");
					
					
				}
				else
					pw.println("<h1 style='color:red;text-align:center'>Employee Not Found...</h1>");
			}
			
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
		pw.println("<br><a href='input.html'>home</a>");
pw.close();
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
	doGet(req,res);
}
}
