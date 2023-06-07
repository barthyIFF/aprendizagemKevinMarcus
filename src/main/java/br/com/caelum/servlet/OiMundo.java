package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      PrintWriter out = response.getWriter();

	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Primeira Servlet</title>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>Oi mundo Servlet!</h1>");
	      out.println("</body>");
	      out.println("</html>");
	  }
}
