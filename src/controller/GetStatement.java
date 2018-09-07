package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class GetStatement extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		ArrayList al = m.statement();
		
		
		if(al!=null)
		{
			session.setAttribute("al",al);
			response.sendRedirect("/BankApp/StatementSuccess.jsp");
			System.out.println(al);
		}
	 	else
	 	{
	 		response.sendRedirect("/BankApp/StatementFailure.jsp");
	 		System.out.println(al);
	 	}
	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
