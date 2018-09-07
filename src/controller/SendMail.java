package controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SendMail extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
		final String fromEmail="ram.27march91@gmail.com";
		final String password="Princeneil@143";
		final String email=request.getParameter("email"); 
		
		
		HttpSession session=request.getSession();
		session.setAttribute("email",email);
		
		
		Properties prop=new Properties();
		
		prop.put("mail.smtp.host","smtp.gmail.com"); 
		prop.put("mail.smtp.port",587); 
		prop.put("mail.smtp.auth","true"); 
		prop.put("mail.smtp.starttls.enable","true"); 
		
		Session session1=Session.getDefaultInstance(prop, new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(fromEmail,password);
			}
		}); 
		
		
		MimeMessage mesg=new MimeMessage(session1);
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
		mesg.setSubject("DO NOT REPLY TO THIS EMAIL");
		mesg.setText("http://localhost:9090/BankApp/resetPassword.jsp");
		Transport.send(mesg);
		response.sendRedirect("/BankApp/mailSent.jsp");
		System.out.println("Message Sent");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
