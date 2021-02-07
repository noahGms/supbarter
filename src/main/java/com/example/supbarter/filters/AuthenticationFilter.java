package com.example.supbarter.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;

		HttpSession session = httpReq.getSession();

		if (session.getAttribute("isLogin") == null) {
			httpResp.sendRedirect(httpReq.getContextPath() + "/login");
		} else {
			chain.doFilter(httpReq, httpResp);
		}
	}

	public void init(FilterConfig config) throws ServletException {
	}
}
