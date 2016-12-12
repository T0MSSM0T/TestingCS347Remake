<%-- 
    Document   : editPassword
    Created on : Dec 11, 2016, 6:47:12 PM
    Author     : hirstrb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Password</title>

        <script type="text/JavaScript">

            function validatePassword()
            {
            var match = true
            var password = get('password').value
            var passwordConfirm = get('passwordcnfm').value
            get('passwordcnfmerr').innerHTML = ''

            if (password != passwordConfirm){
            get('passwordcnfmerr').innerHTML = 'Passwords do not match'
            match = false
            }

            return match
            }

            function get(id) { return document.getElementById(id) }

        </script>
    </head>
    <body>
        <form action="PasswordServlet" method="POST" onsubmit="return validatePassword()">
            <div>
                <input type="password" name="currentPasswordToChange">Current Password</input>
            </div>

            <div>
                <input type="password" name="newPass">New Password</input>
            </div>

            <div>
                <input type="password" name="confPass">Confirm Password</input>
            </div>

            <div>
                <button type="submit" name="action" class="btn btn-primary btn-lg">Change Password</button>
            </div>
        </form>
    </body>
</html>
