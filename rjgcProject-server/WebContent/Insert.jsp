<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="InsertForm" action="Insert" method="post">
<table>
<tr>
      <td>物品名称</td>
      <td><input type="text" name="name"></td>
</tr>
<tr>
      <td>用户id</td>
      <td><input type="text" name="userid"></td>
</tr>
<tr>
      <td>物品种类</td>
      <td>
      <select name="type">
      <option value=1>种类1</option>
      <option value=2>种类2</option>
      <option value=3>种类3</option>
      </select>
      </td>
</tr>
<tr>
      <td>物品价格</td>
      <td><input type="text" name="price"></td>
</tr>
<tr>
      <td>用户名</td>
      <td><input type="text" name="username"></td>
</tr>
<tr>
      <td>用户学校</td>
      <td><input type="text" name="userschool"></td>
</tr>
<tr>
      <td>用户联系方式</td>
      <td><input type="text" name="usercontact"></td>
</tr>
<tr>
      <td>物品描述</td>
      <td><input type="text" name="detail"></td>
</tr>
<tr>
      <td><input type="submit" value="插入"></td>
</tr>
</table>
</form>
</body>
</html>