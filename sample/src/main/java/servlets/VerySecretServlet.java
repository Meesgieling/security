package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class VerySecretServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String code = request.getParameter("code");
		String mailcode = (String) getServletContext().getAttribute("mailcode");
		System.out.println("code : " + mailcode);
		
		RequestDispatcher rd = null;
		if(mailcode.equals(code))
		{
			rd = request.getRequestDispatcher("rest/verysecret/");
		}
		else 
		{
			rd = request.getRequestDispatcher("verysecret.html");
		}
		rd.forward(request, response);
	}
}