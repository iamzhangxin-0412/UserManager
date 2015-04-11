package com.zhangbin.service.impl;

import java.util.List;

import com.zhangbin.dao.EmployeeDao;
import com.zhangbin.dao.impl.EmployeeDaoImpl;
import com.zhangbin.domain.Employee;
import com.zhangbin.domain.Page;
import com.zhangbin.exception.IdIsNullException;
import com.zhangbin.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeDao dao = new EmployeeDaoImpl();
	@Override
	public void addEmployee(Employee e)
	{
		dao.addEmployee(e);
	}

	@Override
	public void delEmployeeById(String employeeId)
	{
		dao.delEmployeeById(employeeId);
	}

	@Override
	public void updateEmployee(Employee e) throws IdIsNullException
	{
		dao.updateEmployee(e);
	}

	@Override
	public List<Employee> findAll()
	{
		return dao.findAll();
	}

	@Override
	public Employee findEmployeeById(String employeeId)
	{
		return dao.findEmployeeById(employeeId);
	}

	@Override
	public Page findPageReocrds(String pagenum)
	{
		int num = 1;//默认值
		if(pagenum!=null&&!"".equals(pagenum.trim()))//如果用户传进来的是null或者是空字符串，则说明第一次访问，默认显示的页码是第1页
			num = Integer.parseInt(pagenum);
		int totalrecords = dao.getTotalRecords();
		Page page = new Page(num, totalrecords);//构造Page对象，因为需要当前页码和总记录条数，所以先通过DAO查出总记录条数
												//Page对象一旦构建出来，那么每页开始记录的索引、总页数等都计算出来了
												//但是Page对象中的分页记录还木有，所以又通过Dao查询的分页记录
												//DAO查询分页记录需要每页开始记录的索引和每页显示的条数，这两个参数Page对象中已经计算完毕了
		List records = dao.findPageRecords(page.getStartIndex(), page.getPagesize());//查询出记录，并设置到Page对象中。这样，任何与分页有关的信息都在Page对象中了
		page.setRecords(records);
		return page;
	}

}
