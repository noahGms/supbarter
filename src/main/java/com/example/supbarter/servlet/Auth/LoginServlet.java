package com.example.supbarter.servlet.Auth;

import com.example.supbarter.dao.daoInterface.IUserDao;
import com.example.supbarter.entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
	@EJB
	IUserDao userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Auth/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// check if form send all values
		if (username.equals("") && password.equals("")) {
			req.setAttribute("error", "user or password not provided");
			req.getRequestDispatcher("/Auth/login.jsp").forward(req, resp);
			return;
		}

		// check if user exist with username
		User user = userDao.findByField(new String[]{"username", username});
		if (user == null) {
			req.setAttribute("error", "user not found");
			req.getRequestDispatcher("/Auth/login.jsp").forward(req, resp);
			return;
		}

		// check password
		if (!user.checkPassword(password)) {
			req.setAttribute("error", "invalid credentials");
			req.getRequestDispatcher("/Auth/login.jsp").forward(req, resp);
			return;
		}

		// create session
		req.getSession().setAttribute("isLogin", true);
		req.getSession().setAttribute("currentUser", user);

		// return to index page
		resp.sendRedirect(req.getContextPath());
	}
}
