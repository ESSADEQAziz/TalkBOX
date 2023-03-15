<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <link rel="stylesheet"  href="${pageContext.request.contextPath}/CSS_folder/Login.css">
  <style>
  .login-box {

  	margin: 80px auto;

    }
  </style>
</head>
<body>

<c:if test="${failure_authentification}">
<script> alert("Username or Password is incorrect ! ");</script>
</c:if>

<c:if test="${!account_active}">
<script> alert("Account is not active yet ! ");</script>
</c:if>

<c:if test="${!failure_creation}">
<script> alert("Active your account via email ! ");</script>
</c:if>

  <div class="login-box">
    <h1>Login</h1>
    <form action="Servlet_1" method="post">
      <label for="username">Username</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>
      <label for="password">Password</label>
      <input style="margin-bottom: 10px;" type="password" id="password" name="password" placeholder="Enter your password" required>
	  <a href="" id="forget">foget your password?</a>
      <button type="submit">Login</button>
	  <hr>
	  <a href="/App_2/Servlet_2" ><button type="button" id="signin">Sign in</button></a>
    </form>
  </div>
</body>
</html>