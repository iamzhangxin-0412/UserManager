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
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet
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
		try {
			//填充数据，验证数据
			EmployeeFormBean formBean = FormBeanUtil.fillFormBean(EmployeeFormBean.class, request);
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				request.getRequestDispatcher("/addEmployee.jsp").forward(request, response);
				return;
			}
			//填充模型：FormBean---》JavaBean
			Employee c = new Employee();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(c, formBean);
			//保存数据到数据库中
			e.addEmployee(c);
			request.setAttribute("message", "添加成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", "对不起！服务器忙");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
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
