package com.example.supbarter.servlet.User;

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
import java.util.List;

@WebServlet(name = "MyObjectServlet", value = "my-objects")
public class MyObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User currentUser = (User) req.getSession().getAttribute("currentUser");

		// get objects of currentUser
		List<Object> myObjects = objectDao.getByUserId(currentUser.getId());

		// return to my-object page with objects of current user
		req.setAttribute("objects", myObjects);
		req.getRequestDispatcher("/User/objects.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
