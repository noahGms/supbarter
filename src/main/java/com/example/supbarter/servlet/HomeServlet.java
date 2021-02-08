package com.example.supbarter.servlet;

import com.example.supbarter.dao.daoInterface.IObjectDao;
import com.example.supbarter.dao.daoInterface.IUserDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/")
public class HomeServlet extends HttpServlet {
	@EJB
	IUserDao userDao;

	@EJB
	IObjectDao objectDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("numberOfObjects", objectDao.count());
		req.setAttribute("numberOfUsers", userDao.count());
		req.setAttribute("recentObjects", objectDao.getWithLimit(3));
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
