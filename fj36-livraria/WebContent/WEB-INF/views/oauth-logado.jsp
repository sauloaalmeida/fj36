<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
Código de autenticaçao): ${autenticationToken}<br>
AccessToken (Authorization:Bearer): ${accessToken}
<br><br>Cole no campo abaixo o AccessToken para testar o request autorizado.
<br><br>
<form action="githubRequest">
<label for="token">AccessToken:</label>
<input type="text" name="accessToken">
<input type="submit" value="Enviar Request ao Github">
</form>
<br><br>
${responseBody}
</body>
</html> 