package com.example.supbarter.servlets;

import com.example.supbarter.dao.IUserDao;
import com.example.supbarter.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "usersServlet", value = "/users")
public class UserServlet extends HttpServlet {
	@EJB
	IUserDao userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", userDao.getAll());
		req.getRequestDispatcher("/Users/users.jsp").forward(req, resp);
	}
}
