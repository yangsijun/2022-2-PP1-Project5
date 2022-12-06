<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
  <style>
    #login-img {
        height: 250px;
        margin: 20px;
    }
    #login-button {
        margin: 5px;
    }
    #login-form {
        margin: 20px;
    }
    .login-label {
        padding: 0 10px 0 10px;
    }
    .login-input {
        width: 150px;
        margin: 0 5px 0 5px;
    }
  </style>
</head>
<body>
  <img src="../img/login_page_img.png" id="login-img">
  <form method="post" action="loginOk" id="login-form">
    <table>
      <tr>
        <td><label class="col-form-label login-label">User ID </label></td>
        <td><input class="form-text login-input" type="text" name="userid" /></td>
      </tr>
      <tr>
        <td><label class="col-form-label login-label">Password </label></td>
        <td><input class="form-text login-input" type="password" name="password" /></td>
      </tr>
      <tr>
        <td>
          <button type="submit" class="btn btn-primary" id="login-button">
            <i class="fa fa-lock-open"></i> Login
          </button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
