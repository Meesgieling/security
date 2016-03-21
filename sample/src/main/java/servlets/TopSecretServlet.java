package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopSecretServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		RequestDispatcher rd = null;
		if (name != null) {
			if (name.equals("admin")) {
				if (pass.equals("admin")) {
					rd = request.getRequestDispatcher("topemail.html");
				} else {
					rd = request.getRequestDispatcher("topsecret.html");
				}
			} else {
				rd = request.getRequestDispatcher("topsecret.html");
			}
		} else {
			String code = request.getParameter("code");
			String mailcode = (String) getServletContext().getAttribute(
					"mailcode");
			System.out.println("code : " + mailcode);

			if (mailcode.equals(code)) {
				rd = request.getRequestDispatcher("rest/topsecret/");
			} else {
				rd = request.getRequestDispatcher("topsecret.html");
			}
		}

		rd.forward(request, response);
	}
}