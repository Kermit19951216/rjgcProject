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
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
			String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(name);
			String userid=request.getParameter("userid");
			System.out.println(userid);
			String type=request.getParameter("type");
			System.out.println(type);
			String price=request.getParameter("price");
			System.out.println(price);
			String username=new String(request.getParameter("username").getBytes("iso-8859-1"), "UTF-8");
			String userschool=new String(request.getParameter("userschool").getBytes("iso-8859-1"), "UTF-8");
			String usercontact=new String(request.getParameter("usercontact").getBytes("iso-8859-1"), "UTF-8");
			String detail=new String(request.getParameter("detail").getBytes("iso-8859-1"), "UTF-8");
			String sql=
					"insert into goodstable (name,userid,type,price,username,userschool,usercontact,detail) value('"
			+name+"',"+userid+","+type+","+price+",'"+username+"','"+
							userschool+"','"+usercontact+"','"+detail+"')";
			System.out.println(sql);
			Connection con=DBUtil.getConnection();
			Statement stmt=con.createStatement();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			writer=response.getWriter();
			int count=stmt.executeUpdate(sql);
			if(count>0){
				flag=true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.Close();
			writer.println(flag);
			writer.flush();
			writer.close();
		}
	}

}
