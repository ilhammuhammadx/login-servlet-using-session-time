package com.candidjava.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un= request.getParameter("uname");
		String pw= request.getParameter("pass");
		
		PrintWriter out=response.getWriter();
		Cookie ck=new Cookie("auth", un);
		ck.setMaxAge(60);
	    if(un.equals("admin")&pw.equals("admin"))
	    {
	    	response.addCookie(ck);
	    	response.sendRedirect("home.jsp");
	    	return;
	    }
	    else
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("login.html");
	        out.println("<font color=red>Username atau password tidak cocok.</font>");
	        rd.include(request, response);
	    }}}
