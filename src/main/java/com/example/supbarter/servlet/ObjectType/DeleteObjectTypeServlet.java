package com.example.supbarter.servlet.ObjectType;

import com.example.supbarter.dao.daoInterface.IObjectTypeDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteObjectTypeServlet", value = "delete-object-types")
public class DeleteObjectTypeServlet extends HttpServlet {
	@EJB
	IObjectTypeDao objectTypeDao;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));

		// remove object type
		objectTypeDao.remove(id);

		// return to object type list page
		resp.sendRedirect(req.getContextPath() + "/object-types");
	}
}
