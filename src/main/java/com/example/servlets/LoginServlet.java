package com.example.servlets;

import com.example.utils.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, role FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("role", role);
                    switch (role) {
                        case "Employee":
                            response.sendRedirect("requestAccess.jsp");
                            break;
                        case "Manager":
                            response.sendRedirect("pendingRequests.jsp");
                            break;
                        case "Admin":
                            response.sendRedirect("createSoftware.jsp");
                            break;
                    }
                } else {
                    response.getWriter().write("Invalid credentials.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
