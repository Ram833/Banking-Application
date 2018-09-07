package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;


public class ResetPassword extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String npass=request.getParameter("npass");
			HttpSession session=request.getSession();
			
			String email=(String) session.getAttribute("email");
			Model m=new Model();
			m.setNpass(npass);
			m.setEmail(email);
			boolean b=m.email();
			
			if(b==true)
			{
				response.sendRedirect("/BankApp/resetSuccess.jsp");
			}
			else
			{
				response.sendRedirect("/BankApp/resetFailure.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
