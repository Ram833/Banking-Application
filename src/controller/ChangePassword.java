package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;


public class ChangePassword extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cnpass=request.getParameter("cnpass");
		
		if(npass.equals(cnpass)==true)
		{
			HttpSession session=request.getSession();
			String accno=(String) session.getAttribute("accno");
			
			Model m=new Model();
			m.setNpass(npass);
			m.setAccno(accno);
			boolean b=m.changePassword();
			if(b==true)
			{
				response.sendRedirect("/BankApp/PasswordChangeSuccess.jsp");
			}
			else
			{
				response.sendRedirect("/BankApp/PasswordChangeFailure.jsp");
			}
		}
		else
		{
			response.sendRedirect("/BankApp/PasswordChangeFailure.jsp");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
