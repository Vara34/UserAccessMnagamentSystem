package com.example.servlets;

import com.example.utils.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SoftwareServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String[] accessLevels = request.getParameterValues("access_levels");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, description);
                stmt.setArray(3, conn.createArrayOf("TEXT", accessLevels));
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.sendRedirect("createSoftware.jsp");
                } else {
                    response.getWriter().write("Error: Software creation failed.");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
