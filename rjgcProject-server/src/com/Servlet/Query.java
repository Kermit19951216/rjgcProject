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
import com.google.gson.JsonArray;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import com.mysql.jdbc.Connection;
//import sun.security.provider.JavaKeyStore.CaseExactJKS;

//import sun.security.provider.JavaKeyStore.CaseExactJKS;

/**
 * Servlet implementation class Query
 */
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
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
		//boolean type=false;
		//String column=null;
		String sql=null;
		JSONArray jsonArray=new JSONArray();
		try{
			String target=new String(request.getParameter("target").getBytes("iso-8859-1"), "UTF-8");
			String row=request.getParameter("row");
			String num=request.getParameter("num");
			String[] tempstring=target.split(" ");
			if(tempstring!=null){
				sql="select * from goodstable where";
			}
			for (int i=0;i<tempstring.length;i++){
				String item=tempstring[i];
				sql=sql+" (name like '%"+item+"%' or "
						+"username like '%"+item+"%' or "
						+"userschool like '%"+item+"%' or "
						+"detail like '%"+item+"%')";
				if(i!=tempstring.length-1)
					sql=sql+" and ";
			}
			sql=sql+" order by id desc limit "+row+","+num;
			/*sql="select * from goodstable where name like '%"+target+"%' or "
					+"username like '%"+target+"%' or "
					+"userschool like '%"+target+"%' or "
					+"detail like '%"+target+"%'";*/
			System.out.println(sql);
			response.setContentType("text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			writer=response.getWriter();
			Connection con=DBUtil.getConnection();
			Statement stmt=con.createStatement();
			//System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("id", rs.getInt("id"));
				jsonObject.put("name", rs.getString("name"));
				jsonObject.put("userid", rs.getInt("userid"));
				jsonObject.put("type", rs.getInt("type"));
				jsonObject.put("price", rs.getFloat("price"));
				jsonObject.put("username", rs.getString("username"));
				jsonObject.put("userschool", rs.getString("userschool"));
				jsonObject.put("detail", rs.getString("detail"));
				jsonObject.put("usercontact", rs.getString("usercontact"));
				jsonArray.add(jsonObject);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.Close();
			writer.write(jsonArray.toString());
			writer.flush();
			writer.close();
		}
	}

}
