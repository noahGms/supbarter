package com.example.supbarter.servlet.Object;

import com.example.supbarter.dao.daoInterface.IObjectDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ObjectServlet", value = "/objects")
public class ObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("objects", objectDao.getAll());
		req.getRequestDispatcher("/Object/index.jsp").forward(req, resp);
	}
}
