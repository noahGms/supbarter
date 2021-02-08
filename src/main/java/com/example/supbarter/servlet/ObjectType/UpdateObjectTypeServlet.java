package com.example.supbarter.servlet.ObjectType;

import com.example.supbarter.dao.daoInterface.IObjectTypeDao;
import com.example.supbarter.entity.ObjectType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateObjectTypeServlet", value = "update-object-types/*")
public class UpdateObjectTypeServlet extends HttpServlet {
	@EJB
	IObjectTypeDao objectTypeDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get id from url
		Long id = Long.valueOf(req.getPathInfo().substring(1));

		// find object type
		ObjectType objectType = objectTypeDao.findById(id);

		// return to update form with object type
		req.setAttribute("objectType", objectType);
		req.getRequestDispatcher("/ObjectType/update.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String name = req.getParameter("name");

		// check if object type with id exist
		ObjectType objectType = objectTypeDao.findById(id);
		if (objectType == null) {
			req.setAttribute("error", "object type not found");
			req.setAttribute("objectType", objectType);
			req.getRequestDispatcher("/ObjectType/index.jsp").forward(req, resp);
			return;
		}

		// check if name is empty
		if (name.isEmpty()) {
			req.setAttribute("error", "name is empty");
			req.setAttribute("objectType", objectType);
			req.getRequestDispatcher("/ObjectType/update.jsp").forward(req, resp);
			return;
		}

		// update object type
		objectType.setName(name);

		objectTypeDao.update(id, objectType);

		// return to object type index page
		resp.sendRedirect(req.getContextPath() + "/object-types");
	}
}
