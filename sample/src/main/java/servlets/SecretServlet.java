package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class SecretServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		RequestDispatcher rd = null;
		
		if (name.equals("Ernie")) {
			if (pass.equals("Bert")) {
				rd = request.getRequestDispatcher("rest/secret/");
			}
			else {
				rd = request.getRequestDispatcher("secret.html");
			}
		}
		else {
			rd = request.getRequestDispatcher("secret.html");
		}
		
		rd.forward(request, response);
	}
}