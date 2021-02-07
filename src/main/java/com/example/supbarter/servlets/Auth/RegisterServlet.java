package com.example.supbarter.servlets.Auth;

import com.example.supbarter.dao.IUserDao;
import com.example.supbarter.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
	@EJB
	private IUserDao userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Auth/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		String passwordConfirmation = req.getParameter("passwordConfirmation");
		String zipCode = req.getParameter("zipCode");

		// check if form send all values
		if (email.equals("") || username.equals("") || password.equals("") || passwordConfirmation.equals("") || firstname.equals("") || lastname.equals("") || zipCode.equals("") ) {
			req.setAttribute("error", "information missing");
			req.getRequestDispatcher("/Auth/register.jsp").forward(req, resp);
			return;
		}

		// check if passwordConfirmation equals to password
		if (!password.equals(passwordConfirmation)) {
			req.setAttribute("error", "passwords not match");
			req.getRequestDispatcher("/Auth/register.jsp").forward(req, resp);
			return;
		}

		// create user
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setUsername(username);
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setPassword(password);
		newUser.setLastname(lastname);
		newUser.setZipcode(Integer.parseInt(zipCode));

		userDao.create(newUser);

		// return to login page
		req.getRequestDispatcher("/Auth/login.jsp").forward(req, resp);
	}
}
