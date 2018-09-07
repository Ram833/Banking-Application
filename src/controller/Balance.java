package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;


public class Balance extends HttpServlet 
{
	HttpSession session;
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
	  try
	   {
		session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		Model m = new Model();
		m.setAccno(accno);
		boolean b = m.checkBalance();
		
		if(b==true)
		{
			session.setAttribute("balance",m.getBalance());
			response.sendRedirect("/BankApp/balanceSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/BankApp/balanceFailure.jsp");
		}
	   }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	}

}
