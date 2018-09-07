package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Home1 extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		String custid = request.getParameter("custid");
		String pwd = request.getParameter("pwd");
		
		try {
		Model m = new Model();
		m.setCustid(custid);
		m.setPwd(pwd);
		boolean status = m.login();
		if(status==true)
		{
			String accno = m.getAccno();
			String name = m.getName();
			HttpSession session = request.getSession(true);
			session.setAttribute("accno",accno);
			session.setAttribute("name", name);
		    response.sendRedirect("/BankApp/home.jsp");
			
		}
		else
		{
			response.sendRedirect("/BankApp/loginFailed.jsp");	
		}
	  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
