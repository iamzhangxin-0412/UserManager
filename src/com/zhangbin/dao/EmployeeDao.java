package com.zhangbin.dao;

import java.util.List;

import com.zhangbin.domain.Employee;
import com.zhangbin.exception.IdIsNullException;

public interface EmployeeDao
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
	 * 查询记录的总条数
	 */
	int getTotalRecords();
	/**
	 * 查询分页数据
	 * @param startIndex 每页开始记录的索引编号
	 * @param pagesize 每页显示的记录条数
	 * @return
	 */
	List<Employee> findPageRecords(int startIndex,int pagesize);
}
