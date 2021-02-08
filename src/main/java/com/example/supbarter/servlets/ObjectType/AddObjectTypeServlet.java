package com.example.supbarter.servlets.ObjectType;

import com.example.supbarter.dao.interfaces.IObjectTypeDao;
import com.example.supbarter.entities.ObjectType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddObjectTypeServlet", value = "/add-object-types")
public class AddObjectTypeServlet extends HttpServlet {
	@EJB
	IObjectTypeDao objectTypeDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/ObjectType/add.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		// check if name is present
		if (name.equals("")) {
			req.setAttribute("error", "name missing");
			req.getRequestDispatcher("/ObjectType/list.jsp").forward(req, resp);
			return;
		}

		// create new object type
		ObjectType newObjectType = new ObjectType();
		newObjectType.setName(name);

		objectTypeDao.create(newObjectType);

		// return to object type list page
		resp.sendRedirect(req.getContextPath() + "/object-types");
	}
}
