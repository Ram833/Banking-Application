package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/BankApp/index.html");
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
