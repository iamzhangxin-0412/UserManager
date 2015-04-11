package com.zhangbin.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.zhangbin.dao.EmployeeDao;
import com.zhangbin.dao.impl.EmployeeDaoImpl;
import com.zhangbin.domain.Employee;
import com.zhangbin.exception.IdIsNullException;

public class EmployeeDaoImplTest
{
	private EmployeeDao dao = new EmployeeDaoImpl();
	@Test
	public void testAddEmployee()
	{
		Employee e = new Employee();
		e.setId("001");
		e.setName("张斌");
		e.setBirthday(new Date(93,8,11));
		e.setGender("1");
		e.setCellphone("18623198412");
		e.setEmail("sanjin6035@hotmail.com");
		e.setSalary("2000");
		dao.addEmployee(e);
	}

	@Test
	public void testUpdateEmployee() throws IdIsNullException
	{
		Employee e = new Employee();
		e.setId("001");
		e.setName("张鑫");
		e.setBirthday(new Date(93,8,11));
		e.setGender("1");
		e.setCellphone("18623198412");
		e.setEmail("sanjin6035@hotmail.com");
		e.setSalary("2000");
		dao.updateEmployee(e);
	}

	@Test
	public void testFindAll()
	{
		List<Employee> em =dao.findAll();
		assertEquals(1, em.size());
	}

	@Test
	public void testFindEmployeeById()
	{
		Employee e = dao.findEmployeeById("001");
		assertNotNull(e);
		e = dao.findEmployeeById("gujhhjjhh");
		assertNull(e);
	}

	@Test
	public void testDelEmployeeById()
	{
		dao.delEmployeeById("001");
	}
}
