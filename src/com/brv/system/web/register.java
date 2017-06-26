package com.brv.system.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brv.system.domian.SysUser;
import com.brv.system.service.SysService;
import com.brv.system.service.SysServiceImpl;
import com.brv.system.util.SysUtil;

/**
 * Servlet implementation class register
 */
@WebServlet("/register.do")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private SysService systemService = new SysServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8"); 
        String username = request.getParameter("username");  
        String password = request.getParameter("password"); 
        try{
        	String rpsw = request.getParameter("rpsw");//得到表单输入的内容
        	if(username==null||username.trim().isEmpty()){  
                request.setAttribute("msg", "帐号不能为空");  
                request.getRequestDispatcher("view/register/register1.jsp").forward(request, response);  
                return;  
            }  
            if(password==null||password.trim().isEmpty()){  
                request.setAttribute("msg", "密码不能为空");  
                request.getRequestDispatcher("view/register/register1.jsp").forward(request, response);  
                return;  
            }  
            if(!password.equals(rpsw)){  
                request.setAttribute("msg", "两次输入的密码不同");  
                request.getRequestDispatcher("view/register/register1.jsp").forward(request, response);  
                return;  
            }  
        	
        	systemService.addUser(username, password);
        	response.sendRedirect("view/register/register_complete.html"); 
           
          
        }
        catch(Exception e){
        
 
//        	
      
        }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
