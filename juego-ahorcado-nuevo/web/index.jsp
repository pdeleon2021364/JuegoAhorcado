<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
  <div class="container">
    <form class="form" id="loginForm" action="Validar" method="POST">
      <p class="title">Login Form</p>
      <input name="username" placeholder="Username" class="username input" type="text" required />
      <input name="password" placeholder="Password" class="password input" type="password" required />
      <button class="btn" type="submit" name="accion" value="Ingresar">Login</button>
      <% 
        String error = (String) request.getAttribute("error");
        if(error != null){ 
      %>
          <p style="color:red; margin-top:10px;"><%= error %></p>
      <% } %>
    </form>
  </div>
</body>
</html>
