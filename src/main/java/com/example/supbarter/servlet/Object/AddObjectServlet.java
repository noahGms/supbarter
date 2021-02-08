package com.example.supbarter.servlet.Object;

import com.example.supbarter.dao.daoInterface.IObjectDao;
import com.example.supbarter.dao.daoInterface.IObjectTypeDao;
import com.example.supbarter.entity.Object;
import com.example.supbarter.entity.ObjectType;
import com.example.supbarter.entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddObjectServlet", value = "add-objects")
public class AddObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	@EJB
	IObjectTypeDao objectTypeDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("objectTypes", objectTypeDao.getAll());
		req.getRequestDispatcher("/Object/add.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String picture = req.getParameter("picture");
		String type = req.getParameter("type");

		if (title.isEmpty() || description.isEmpty() || price.isEmpty() || picture.isEmpty() || type.isEmpty()) {
			req.setAttribute("error", "information missing");
			req.setAttribute("objectTypes", objectTypeDao.getAll());
			req.getRequestDispatcher("/Object/add.jsp").forward(req, resp);
			return;
		}

		ObjectType objectType = objectTypeDao.findById(Long.parseLong(type));
		if (objectType == null) {
			req.setAttribute("error", "object type not found");
			req.setAttribute("objectTypes", objectTypeDao.getAll());
			req.getRequestDispatcher("/Object/add.jsp").forward(req, resp);
			return;
		}

		// create new object
		Object newObject = new Object();
		newObject.setTitle(title);
		newObject.setDescription(description);
		newObject.setPrice(Double.parseDouble(type));
		newObject.setPicture(picture);
		newObject.setType(objectType);
		newObject.setUser((User) req.getSession().getAttribute("currentUser"));

		objectDao.create(newObject);

		// return to object list page
		resp.sendRedirect(req.getContextPath() + "/objects");
	}
}
