package com.example.supbarter.servlet.Object;

import com.example.supbarter.dao.daoInterface.IObjectDao;
import com.example.supbarter.entity.Object;
import com.example.supbarter.entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteObjectServlet", value = "/delete-objects")
public class DeleteObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));

		// get object & current user
		Object object = objectDao.findById(id);
		User currentUser = (User) req.getSession().getAttribute("currentUser");

		// check if currentUser is user object
		if (object.getUser().getId() != currentUser.getId()) {
			req.setAttribute("error", "you can't delete this object");
			req.setAttribute("objects", objectDao.getAll());
			req.getRequestDispatcher("/Object/index.jsp").forward(req, resp);
			return;
		}

		// delete object
		objectDao.remove(id);

		// return to objects index page
		resp.sendRedirect(req.getContextPath() + "/objects");
	}
}
