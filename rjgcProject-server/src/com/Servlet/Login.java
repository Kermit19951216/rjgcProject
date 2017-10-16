package com.Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtil.DBUtil;
import com.google.gson.JsonObject;
//import com.alibaba.fastjson.JSON;
import com.model.User;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

import net.sf.json.JSONObject;
import sun.security.x509.AuthorityInfoAccessExtension;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    private User inti(){
    	User user=new User();
    	user.setauthority(false);
    	user.setcontactway("QQxxxxxxxxx");
    	user.setid(1);
    	user.setname("example");
    	user.setpassword("a4569852");
    	user.setschool("SCNU");
    	
    	return user;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter writer=null;boolean type=false;
		JSONObject jObject=new JSONObject();
		try{
			String id=new String(request.getParameter("ID").getBytes("iso-8859-1"),"utf-8");
			//String str = new String(id.getBytes("iso-8859-1"), "utf-8");  
			//System.out.println(id);
			//System.out.println(str);
			String pw=request.getParameter("PW");
			response.setContentType("text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			//out=response.getOutputStream();
			writer=response.getWriter();
			Connection con=DBUtil.getConnection();
			Statement stmt=con.createStatement();
			String sql="select * from usertable where name='"+id+"' and password='"+pw+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				int uid=rs.getInt("id");
				String name=rs.getString("name");
				String password=rs.getString("password");
				String contactway=rs.getString("contactway");
				String school=rs.getString("school");
				boolean authority=rs.getBoolean("authority");
				type=true;
				jObject.put("id", uid);
				jObject.put("name", name);
				jObject.put("password", password);
				jObject.put("contactway", contactway);
				jObject.put("school", school);
				jObject.put("authority", authority);
				jObject.put("type", type);
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.Close();
			writer.println(jObject.toString());
			System.out.println(jObject.toString());
			writer.close();
		}
	}

}
