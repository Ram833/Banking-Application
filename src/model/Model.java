package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	private String accno;
	private String custid;
	private String pwd;
	private int balance;
	private String email;
	private String name;
	private String tpaccnum;
	private int amount;
	private String npass;
	private String cnpass;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	public Model() throws Exception
	{
		DriverManager.registerDriver(new OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","SYSTEM","system");
		
	}
	
	public String getNpass() {
		return npass;
	}
	public void setNpass(String npass) {
		this.npass = npass;
	}
	public String getCnpass() {
		return cnpass;
	}
	public void setCnpass(String cnpass) {
		this.cnpass = cnpass;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTpaccnum() {
		return tpaccnum;
	}
	public void setTpaccnum(String tpaccnum) {
		this.tpaccnum = tpaccnum;
	}
	
	public boolean login()
	{
		try {
		pstmt = con.prepareStatement("SELECT * FROM BANK WHERE CUSTID=? AND PWD=?");
		pstmt.setString(1, custid);
		pstmt.setString(2, pwd);
		res = pstmt.executeQuery();
		if(res.next()==true)
		{
			accno = res.getString("accno");
			name = res.getString("name");
			return true;
		}

	   }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkBalance()
	{
	  try 
	  {
		pstmt = con.prepareStatement("Select * from BANK where ACCNO=?");
		pstmt.setString(1, accno);
		res = pstmt.executeQuery();
		
		while(res.next()==true)
		{
			balance = res.getInt("balance");
			return true;
		}
	  }
	   catch(Exception e)
		{
			e.printStackTrace();
		}
	  return false;
	}
	
	public boolean transfer()
	{
		try
		{
		pstmt = con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCNO=?");
		pstmt.setInt(1, amount);
		pstmt.setString(2, accno);
		int a = pstmt.executeUpdate();
		
		pstmt = con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE+? WHERE ACCNO=?");
		pstmt.setInt(1, amount);
		pstmt.setString(2, tpaccnum);
		int b = pstmt.executeUpdate();
		
		pstmt = con.prepareStatement("INSERT INTO STATEMENT VALUES(?,?)");
		pstmt.setString(1, accno);
		pstmt.setInt(2, amount);
		pstmt.executeUpdate();
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList statement()
	{
		try
		{
		pstmt=con.prepareStatement("Select * from STATEMENT where ACCNO=?");
		pstmt.setString(1,accno);
		res=pstmt.executeQuery();
		
		ArrayList al=new ArrayList();
		
		while(res.next()==true)
		{
			al.add(res.getString("accno"));
			al.add(res.getInt("amount"));
		}
		return al;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean changePassword()
	{
		try
		{
			pstmt=con.prepareStatement("update BANK set PWD=? where ACCNO=?");
			pstmt.setString(1, npass);
			pstmt.setString(2, accno);
			pstmt.executeUpdate();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean email()
	{
		try
		{
			pstmt=con.prepareStatement("Update BANK set PWD=? where EMAIL=?");
			pstmt.setString(1,npass);
			pstmt.setString(2,email);
			pstmt.executeUpdate();
			
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
}
