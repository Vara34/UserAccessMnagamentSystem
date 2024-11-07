package com.example.servlets;

import com.example.utils.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("request_id"));
        String status = request.getParameter("status"); // 'Approved' or 'Rejected'

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE requests SET status = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, status);
                stmt.setInt(2, requestId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("pendingRequests.jsp");
                } else {
                    response.getWriter().write("Error: Approval process failed.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
