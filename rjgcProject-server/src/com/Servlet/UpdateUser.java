package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtil.DBUtil;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
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
		PrintWriter writer=null;
		boolean flag=false;
		try{
			String id=request.getParameter("id");
			String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
			String school=new String(request.getParameter("school").getBytes("iso-8859-1"),"UTF-8");
			String contactway=new String(request.getParameter("contactway").getBytes("iso-8859-1"),"UTF-8");
			String sql="update usertable set name='"+name+"',school='"+school+"',contactway='"+contactway+"' "
					+"where id="+id;
			String sql2="update goodstable set username='"+name+"',userschool='"+school+"',usercontact='"+contactway+"' where userid="+id;
			System.out.println(sql);
			Connection connection=DBUtil.getConnection();
			Statement statement=connection.createStatement();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			writer=response.getWriter();
			int count=statement.executeUpdate(sql);
			int count2=statement.executeUpdate(sql2);
			if(count>0&&count2>0){
				flag=true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			writer.print(flag);
			writer.flush();
			writer.close();
			DBUtil.Close();
			
		}
	}

}
