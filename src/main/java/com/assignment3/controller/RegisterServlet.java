package com.assignment3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Retrieve parameters from the JSP form
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        
        String hashedPass = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // 2. MD5 Hashing logic as per assignment requirements
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            hashedPass = sb.toString();

            // 3. Database Connection using your local password '1234'
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/nets1038_w2026_ni", "root", "1234");

            // 4. Using Prepared Statements to prevent SQL Injection
            String query = "INSERT INTO registration (username, password, mobile_number, email_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, hashedPass);
            ps.setString(3, mobile);
            ps.setString(4, email);

            int result = ps.executeUpdate();

            if (result > 0) {
                out.println("<html><body>");
                out.println("<h3>Registration Successful!</h3>");
                out.println("<p>Your MD5 Hash stored in DB: <b>" + hashedPass + "</b></p>");
                out.println("<a href='registration.jsp'>Back to Register</a>");
                out.println("</body></html>");
            } else {
                out.println("<h3>Registration Failed. Please try again.</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h3>Error occurred:</h3>");
            out.println("<pre>" + e.getMessage() + "</pre>");
            e.printStackTrace();
        }
    }
}