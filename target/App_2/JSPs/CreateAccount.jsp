<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create Account</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS_folder/CreateAccount.css">
</head>
<body>
  <div class="create-account-box">
    <h1>Create Account</h1>
    <form action="Servlet_2" method="post">
      <label for="username">Username</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>
      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>
      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>
      <label for="age">Age</label>
      <input type="number" id="age" name="age" placeholder="Enter your age" required>
      <button type="submit">Create Account</button>
    </form>
  </div>
</body>
</html>