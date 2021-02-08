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

@WebServlet(name = "UpdateObjectServlet", value = "/update-objects/*")
public class UpdateObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	@EJB
	IObjectTypeDao objectTypeDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get id from url
		Long id = Long.valueOf(req.getPathInfo().substring(1));

		// find object
		Object object = objectDao.findById(id);

		// return to update from with object
		req.setAttribute("object", object);
		req.setAttribute("objectTypes", objectTypeDao.getAll());
		req.getRequestDispatcher("/Object/update.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String picture = req.getParameter("picture");
		String type = req.getParameter("type");

		// check if object with id exist
		Object object = objectDao.findById(id);
		if (object == null) {
			// use session to show error because you need to sendRedirect instead of getRequestDispatcher
			req.getSession().setAttribute("updateObjectError", "object not found");
			resp.sendRedirect(req.getContextPath() + "/objects");
			return;
		}

		// check if currentUser is user object
		User currentUser = (User) req.getSession().getAttribute("currentUser");
		if (object.getUser().getId() != currentUser.getId()) {
			// use session to show error because you need to sendRedirect instead of getRequestDispatcher
			req.getSession().setAttribute("updateObjectError", "you can't update this object");
			resp.sendRedirect(req.getContextPath() + "/objects");
			return;
		}

		// check if fields form is empty
		if (title.isEmpty() || description.isEmpty() || price.isEmpty() || picture.isEmpty() || type.isEmpty()) {
			req.setAttribute("error", "information missing");
			req.setAttribute("object", object);
			req.setAttribute("objectTypes", objectTypeDao.getAll());
			req.getRequestDispatcher("/Object/update.jsp").forward(req, resp);
			return;
		}

		// check if type exist
		ObjectType objectType = objectTypeDao.findById(Long.parseLong(type));
		if (objectType == null) {
			req.setAttribute("error", "object type not found");
			req.setAttribute("object", object);
			req.setAttribute("objectTypes", objectTypeDao.getAll());
			req.getRequestDispatcher("/Object/update.jsp").forward(req, resp);
			return;
		}

		// update object
		object.setTitle(title);
		object.setDescription(description);
		object.setPrice(Double.parseDouble(price));
		object.setPicture(picture);
		object.setType(objectType);

		objectDao.update(id, object);

		// return to object index page
		resp.sendRedirect(req.getContextPath() + "/objects");
	}
}
