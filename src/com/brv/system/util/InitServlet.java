package com.brv.system.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.brv.system.service.SysService;
import com.brv.system.service.SysServiceImpl;



public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SysService ss = new SysServiceImpl();
	public void init(ServletConfig config) throws ServletException {
		//初始化查询全部权限
		Constants.ALL_PERMISSIONS = ss.getAllPermissions();
	}

}
