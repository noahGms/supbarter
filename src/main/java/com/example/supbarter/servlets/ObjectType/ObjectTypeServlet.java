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

@WebServlet(name = "ListObjectTypeServlet", value = "/object-types")
public class ObjectTypeServlet extends HttpServlet {
	@EJB
	IObjectTypeDao objectTypeDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("objectTypes", objectTypeDao.getAll());
		req.getRequestDispatcher("/ObjectType/list.jsp").forward(req, resp);
	}
}
