<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="formquery" action="Query" method="post">
<table>
<tr>
      <td>关键字</td>
      <td><input type="text" name="target"></td>
</tr>
<tr>
      <td>开始行</td>
      <td><input type="text" name="row"></td>
</tr>
<tr>
      <td>偏移</td>
      <td><input type="text" name="num"></td>
</tr>
<tr>
      <td colspan="2 aglin="center"><input type="submit" value="查询"></td> 
</tr>
</table>
</form>
</body>
</html>