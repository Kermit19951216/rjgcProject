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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryByUserId
 */
public class QueryByUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByUserId() {
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
		String sql=null;
		JSONArray jsonArray=new JSONArray();
		try{
			String userid=request.getParameter("userid");
			sql="select * from goodstable where userid="+userid;
			response.setContentType("text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			writer=response.getWriter();
			Connection connection=DBUtil.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next()){
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("id", resultSet.getInt("id"));
				jsonObject.put("name", resultSet.getString("name"));
				jsonObject.put("userid", resultSet.getInt("userid"));
				jsonObject.put("type", resultSet.getInt("type"));
				jsonObject.put("price", resultSet.getFloat("price"));
				jsonObject.put("username", resultSet.getString("username"));
				jsonObject.put("userschool", resultSet.getString("userschool"));
				jsonObject.put("detail", resultSet.getString("detail"));
				jsonObject.put("usercontact", resultSet.getString("usercontact"));
				jsonArray.add(jsonObject);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			writer.print(jsonArray.toString());
			writer.flush();
			writer.close();
			DBUtil.Close();
		}
	}

}
