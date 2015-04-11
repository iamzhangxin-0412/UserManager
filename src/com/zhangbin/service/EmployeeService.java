package com.zhangbin.service;

import java.util.List;

import com.zhangbin.domain.Employee;
import com.zhangbin.domain.Page;
import com.zhangbin.exception.IdIsNullException;

public interface EmployeeService
{
	/**
	 * 添加员工信息
	 */
	void addEmployee(Employee e);
	
	/**
	 * 通过员工ID删除员工
	 */
	void delEmployeeById(String employeeId);
	
	/**
	 * 更新员工信息
	 * @param e
	 */
	void updateEmployee(Employee e) throws IdIsNullException;
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	List<Employee> findAll();
	
	/**
	 * 通过ID查询员工
	 * @return
	 */
	Employee findEmployeeById(String employeeId);
	
	/**
	 * 根据用户要看的页码返回封装了分页有关数据的Page对象
	 */
	Page findPageReocrds(String pagenum);
}
