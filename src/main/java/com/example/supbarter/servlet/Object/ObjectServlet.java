package com.example.supbarter.servlet.Object;

import com.example.supbarter.dao.ObjectDao;
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

@WebServlet(name = "ObjectServlet", value = "/objects")
public class ObjectServlet extends HttpServlet {
	@EJB
	IObjectDao objectDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// return to objects index page with objects and pageNumber
		req.setAttribute("objects", objectDao.getAll());
		req.setAttribute("pageNumber", this.calculatePageNumber());
		req.getRequestDispatcher("/Object/index.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("pageNumber");

		// get all objects by page
		List<Object> objects = objectDao.getAllWithPage(Integer.parseInt(page));

		// return to objects index page with objects and pageNumber
		req.setAttribute("pageNumber", this.calculatePageNumber());
		req.setAttribute("objects", objects);
		req.getRequestDispatcher("/Object/index.jsp").forward(req, resp);
	}

	private Double calculatePageNumber() {
		// get number of row in Object tage
		Long numberOfObjects = objectDao.count();

		// parse numberOfObject to Integer
		Integer numberOfObjectInt = Integer.parseInt(String.valueOf(numberOfObjects));

		// parse pageNumber to Double
		Double pageNumberDouble = Double.parseDouble(String.valueOf(ObjectDao.pageSize));

		// divide numberOfObject by pageNumber
		Double pageNumber = Math.ceil((Double) (numberOfObjectInt / pageNumberDouble));

		return pageNumber;
	}
}
