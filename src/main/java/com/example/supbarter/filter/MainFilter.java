package com.example.supbarter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MainFilter")
public class MainFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;

		// add contextPath to session
		httpRequest.getSession().setAttribute("contextPath", httpRequest.getContextPath());

		// do filter with httpRequest session
		chain.doFilter(httpRequest, httpResponse);
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
