package com.zhangbin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangbin.domain.Employee;
import com.zhangbin.domain.Page;
import com.zhangbin.service.EmployeeService;
import com.zhangbin.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class ShowAllEmployeeServlet
 */
public class ShowAllEmployeeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private EmployeeService e = new EmployeeServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		List<Employee> cs = e.findAll();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/listEmployees.jsp").forward(request, response);
//		String pagenum = requesttcher("/listEmployees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
