package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class SameBTransfer extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		String tpaccnum = request.getParameter("tpaccnum");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		Model m = new Model();
		m.setTpaccnum(tpaccnum);
		m.setAmount(amount);
		m.setAccno(accno);
		
		boolean b = m.transfer();
		if(b==true)
		{
			response.sendRedirect("/BankApp/transferSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/BankApp/transferFailure.jsp");
		}
	  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
