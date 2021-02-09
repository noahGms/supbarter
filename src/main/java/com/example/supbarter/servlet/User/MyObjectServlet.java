package com.example.supbarter.servlet.User;

import com.example.supbarter.dao.ObjectDao;
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

		// return to my-object page with objects of current user and page number
		req.setAttribute("objects", myObjects);
		req.setAttribute("pageNumber", this.calculatePageNumber(currentUser.getId()));
		req.getRequestDispatcher("/User/objects.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User currentUser = (User) req.getSession().getAttribute("currentUser");
		String page = req.getParameter("pageNumber");

		// get objects of currentUser
		List<Object> myObjects = objectDao.getByUserIdWithPage(currentUser.getId(), Integer.parseInt(page));

		// return to my-object page with objects of current user and page number
		req.setAttribute("objects", myObjects);
		req.setAttribute("pageNumber", this.calculatePageNumber(currentUser.getId()));
		req.getRequestDispatcher("/User/objects.jsp").forward(req, resp);
	}

	private Double calculatePageNumber(Long userId) {
		// get number of row in Object tage
		Long numberOfObjects = objectDao.countUserObjects(userId);

		// parse numberOfObject to Integer
		Integer numberOfObjectInt = Integer.parseInt(String.valueOf(numberOfObjects));

		// parse pageNumber to Double
		Double pageNumberDouble = Double.parseDouble(String.valueOf(ObjectDao.pageSize));

		// divide numberOfObject by pageNumber
		Double pageNumber = Math.ceil((Double) (numberOfObjectInt / pageNumberDouble));

		return pageNumber;
	}
}
