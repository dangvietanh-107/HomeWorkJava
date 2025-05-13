package com.loginapp.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Thông tin đăng nhập hợp lệ
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Lấy thông tin đăng nhập từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Kiểm tra thông tin đăng nhập
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            // Đăng nhập thành công
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            
            request.setAttribute("message", "Đăng nhập thành công! Xin chào " + username);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            // Đăng nhập thất bại
            request.setAttribute("message", "Đăng nhập thất bại! Tên đăng nhập hoặc mật khẩu không đúng.");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Chuyển hướng đến trang login.jsp khi truy cập GET
        response.sendRedirect("login.jsp");
    }
}