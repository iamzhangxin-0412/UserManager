package com.zhangbin.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.zhangbin.domain.Employee;
import com.zhangbin.service.EmployeeService;
import com.zhangbin.service.impl.EmployeeServiceImpl;
import com.zhangbin.util.FormBeanUtil;
import com.zhangbin.web.formbean.EmployeeFormBean;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
public class UpdateEmployeeServlet extends HttpServlet
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
		request.setCharacterEncoding("UTF-8");

		try
		{
			EmployeeFormBean formBean = FormBeanUtil.fillFormBean(
					EmployeeFormBean.class, request);
			if (!formBean.validate())
			{
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/editEmployee.jsp").forward(
						request, response);
				return;
			}
			// 填充模型：FormBean---》JavaBean
			Employee employee = new Employee();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(employee, formBean);
			// 对爱好进行特殊处理
			// 保存数据到数据库中
			e.updateEmployee(employee);
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}
		catch (Exception e)
		{
			request.setAttribute("message", "对不起！服务器忙");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			e.printStackTrace();
		}
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
