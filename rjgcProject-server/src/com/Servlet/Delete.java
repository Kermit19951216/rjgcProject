package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtil.DBUtil;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		PrintWriter writer=null;
		boolean isdelete=false;
		try{
			String id=request.getParameter("id");
			String sql=
					"delete from goodstable "
					+ "where id="+id;
			System.out.println(sql);
			writer=response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			Connection con=DBUtil.getConnection();
			Statement stmt=con.createStatement();
			//isdelete=stmt.execute(sql);
			int count=stmt.executeUpdate(sql);
			System.out.println(count);
			if(count>0){
				isdelete=true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtil.Close();
			writer.print(isdelete);
			System.out.println(isdelete);
			writer.flush();
			writer.close();
		}
	}

}
