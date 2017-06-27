package com.brv.project.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brv.project.service.ItemService;
import com.brv.project.service.ItemServiceImpl;
import com.brv.system.domian.ItemInfo;
import com.brv.system.domian.Project;
import com.google.gson.Gson;


@WebServlet("/addItem.do")
public class addItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ItemService is=new ItemServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String str = new String(request.getParameter("str").getBytes("ISO-8859-1"),"UTF-8");;
		Gson gson = new Gson();
		ItemInfo i=gson.fromJson(str, ItemInfo.class);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String, Object> map = new HashMap<String,Object>();
	
		try{
			is.addItemInfo(i);
			map.put("code", "200");
			map.put("msg", "项目信息保存成功！");
		}catch(Exception e){
			map.put("code", "500");
			map.put("msg", "项目信息保存失败！");
		}
		
		out.print(gson.toJson(map));
		out.println();
		out.flush();
		out.close();
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
