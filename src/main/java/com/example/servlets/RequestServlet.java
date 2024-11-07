package com.example.servlets;

import com.example.utils.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        int softwareId = Integer.parseInt(request.getParameter("software_id"));
        String accessType = request.getParameter("access_type");
        String reason = request.getParameter("reason");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, 'Pending')";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                stmt.setInt(2, softwareId);
                stmt.setString(3, accessType);
                stmt.setString(4, reason);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("requestAccess.jsp");
                } else {
                    response.getWriter().write("Error: Access request failed.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
