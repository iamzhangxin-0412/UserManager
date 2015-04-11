package com.zhangbin.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ɾ��������¼

import com.zhangbin.service.EmployeeService;
import com.zhangbin.service.impl.EmployeeServiceImpl;
public class DelMultiServlet extends HttpServlet {
	private EmployeeService e = new EmployeeServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids[] = request.getParameterValues("ids");
		if(ids!=null&&ids.length>0){
			for(String id:ids){
				e.delEmployeeById(id);
			}
		}
		request.setAttribute("message", "删除成功");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
