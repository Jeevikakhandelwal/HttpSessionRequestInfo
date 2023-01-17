package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1>Request Header Information</h1>");
		out.println("<table border='1'>");

		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			out.println("<tr>");
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			out.println("<td>" + name + "</td><td>" + value + "</td>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("</body>");
			out.close();
		}
	}
}
