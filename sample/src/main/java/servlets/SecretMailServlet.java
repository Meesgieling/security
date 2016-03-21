package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import nl.hu.v2iac1.rest.resource.SecretMailService;

public class SecretMailServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String code = "" + Integer.toHexString((int) ((Math.random() * 100000000)));
		RequestDispatcher rd = null;
		
		SecretMailService sms = new SecretMailService(email, code);
		getServletContext().setAttribute("mailcode", code);
		rd = request.getRequestDispatcher("emailcode.html");
		
		
		rd.forward(request, response);
	}
}