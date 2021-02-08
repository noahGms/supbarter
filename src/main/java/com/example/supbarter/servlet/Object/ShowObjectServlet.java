package com.example.supbarter.servlet.Object;

import com.example.supbarter.dao.daoInterface.IObjectDao;
import com.example.supbarter.entity.Object;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowObjectServlet", value = "/show-objects/*")
public class ShowObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get id from url
		Long id = Long.valueOf(req.getPathInfo().substring(1));

		// find object
		Object object = objectDao.findById(id);

		// return to update form with object
		req.setAttribute("object", object);
		req.setAttribute("contextPath", req.getContextPath());
		req.getRequestDispatcher("/Object/show.jsp").forward(req, resp);
	}
}
