package com.example.supbarter.servlets.User;

import com.example.supbarter.dao.interfaces.IUserDao;
import com.example.supbarter.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value="update-user")
public class UpdateUserServlet extends HttpServlet {
	@EJB
	IUserDao userDao;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Users/update.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("currentUser");
		String email = req.getParameter("email");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String zipCode = req.getParameter("zipcode");

		String currentPassword = req.getParameter("currentPassword");
		String newPassword = req.getParameter("newPassword");
		String newPasswordConfirmation = req.getParameter("newPasswordConfirmation");

		// check if password inputs
		if (!currentPassword.equals("") || !newPassword.equals("") || !newPasswordConfirmation.equals("")) {
			// if passwords, check if all password input are present
			if (currentPassword.equals("") || newPassword.equals("") || newPasswordConfirmation.equals("")) {
				req.setAttribute("error", "password information missing");
				req.getRequestDispatcher("/Users/update.jsp").forward(req, resp);
				return;
			}

			// check if currentPassword is good
			if (!user.checkPassword(currentPassword)) {
				req.setAttribute("error", "current password not match");
				req.getRequestDispatcher("/Users/update.jsp").forward(req, resp);
				return;
			}

			// check if newPassword equal to newPasswordConfirmation
			if (!newPassword.equals(newPasswordConfirmation)) {
				req.setAttribute("error", "new passwords not match");
				req.getRequestDispatcher("/Users/update.jsp").forward(req, resp);
				return;
			}

			user.setPassword(newPassword);
		}

		// update user
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setZipcode(Integer.parseInt(zipCode));

		userDao.update(user.getId(), user);

		// return to index page
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
