package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// Collecting request parameters
		String name = request.getParameter("name");
		String value = request.getParameter("value");

		HttpSession session = request.getSession();
		if (session.isNew()) {
			out.println("<h1>New Session got created with the id :: " + session.getId() + "</h1>");
		} else {
			out.println("<h1>Existing Session is used with the id:: " + session.getId() + "</h1>");
		}

		session.setAttribute(name, value);
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.include(request, response);
	}

}
