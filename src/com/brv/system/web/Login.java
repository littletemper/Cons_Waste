package com.brv.system.web;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brv.system.domian.SysUser;
import com.brv.system.service.SysService;
import com.brv.system.service.SysServiceImpl;
import com.brv.system.util.SysUtil;
import com.mysql.jdbc.Constants;



@WebServlet("/login.do")
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	

	private SysService systemService = new SysServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("userpwd");
		try
		{
			SysUser user = systemService.login(userName, userPwd);
			//HttpSession session = request.getSession();
			//session.setAttribute(Constants.MILLIS_I18N, user);
//			response.sendRedirect("https://www.baidu.com/index.php?tn=monline_3_dg");
			response.sendRedirect("view/index/index.html");
		} catch (Exception e)
		{
			// 登录失败
		
			 request.setAttribute("msg", "用户名或错误！");  
			request.getRequestDispatcher("view/register/login.jsp").forward(request, response);
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
