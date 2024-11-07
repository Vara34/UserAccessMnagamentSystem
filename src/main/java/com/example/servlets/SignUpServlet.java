package com.example.servlets;

import com.example.utils.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "Employee"; // Default role

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, role);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("login.jsp"); // Redirect to login page
                } else {
                    response.getWriter().write("Error: User registration failed.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
