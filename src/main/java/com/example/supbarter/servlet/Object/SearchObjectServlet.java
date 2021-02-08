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
import java.util.List;

@WebServlet(name = "SearchObjectServlet", value = "search")
public class SearchObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchText = req.getParameter("searchText");

		// search objects
		List<Object> objects = objectDao.search(searchText);

		// return to object index page with objects searched
		req.setAttribute("objects", objects);
		req.getRequestDispatcher("Object/index.jsp").forward(req, resp);
	}
}
