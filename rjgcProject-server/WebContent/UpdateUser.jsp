<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateUser" method="post">
<table>
<tr>
      <td>用户id</td>
      <td><input type="text" name="id"></td>
</tr>
<tr>
      <td>用户名</td>
      <td><input type="text" name="name"></td>
</tr>
<tr>
      <td>用户学校</td>
      <td><input type="text" name="school"></td>
</tr>
<tr>
      <td>联系方式</td>
      <td><input type="text" name="contactway"></td>
</tr>
<tr>
      <td colspan="2 align="center"><input type="submit" value="更新用户信息"></td> 
</tr>
</table>
</form>
</body>
</html>