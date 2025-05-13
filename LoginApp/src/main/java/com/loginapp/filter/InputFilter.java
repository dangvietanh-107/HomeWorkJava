package com.loginapp.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/login")
public class InputFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Phương thức khởi tạo filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Chỉ kiểm tra request POST (khi submit form đăng nhập)
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            String username = request.getParameter("username");
            
            // Kiểm tra username không được để trống
            if (username == null || username.trim().isEmpty()) {
                request.setAttribute("error", "Tên đăng nhập không được để trống!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        }
        
        // Nếu dữ liệu hợp lệ, tiếp tục chuỗi filter
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Phương thức hủy filter
    }
}