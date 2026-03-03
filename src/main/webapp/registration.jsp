<h2>Registration Page</h2>
<form action="RegisterServlet" method="post">
    <table>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" required></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td>ReType Password</td>
            <td><input type="password" name="repassword" required></td>
        </tr>
        <tr>
            <td>Mobile Number</td>
            <td><input type="text" name="mobile"></td>
        </tr>
        <tr>
            <td>Email Id</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>Enter Captcha Image</td>
            <td><input type="text" name="captcha"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>