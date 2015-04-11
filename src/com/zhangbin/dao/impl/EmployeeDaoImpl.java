package com.zhangbin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zhangbin.dao.EmployeeDao;
import com.zhangbin.domain.Employee;
import com.zhangbin.exception.DaoException;
import com.zhangbin.exception.IdIsNullException;
import com.zhangbin.util.JDBCUtil;

public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public void addEmployee(Employee e)
	{
		if (e == null)
		{
			throw new IllegalArgumentException();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "insert into customer (id,name,gender,birthday,cellphone,email,salary) values(?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getId());
			stmt.setString(2, e.getName());
			stmt.setString(3, e.getGender());
			stmt.setDate(4, new java.sql.Date(e.getBirthday().getTime()));
			stmt.setString(5, e.getCellphone());
			stmt.setString(6, e.getEmail());
			stmt.setString(7, e.getSalary());
			stmt.executeUpdate();
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public void delEmployeeById(String employeeId)
	{
		if (employeeId == null)
		{
			throw new IllegalArgumentException();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "delete from customer where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employeeId);
			stmt.executeUpdate();
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public void updateEmployee(Employee e) throws IdIsNullException
	{
		if (e == null)
		{
			throw new IllegalArgumentException();
		}
		if (e.getId() == null)
		{
			throw new IdIsNullException("员工编号不能为空");
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,salary=? where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getName());
			stmt.setString(2, e.getGender());
			stmt.setDate(3, new java.sql.Date(e.getBirthday().getTime()));
			stmt.setString(4, e.getCellphone());
			stmt.setString(5, e.getEmail());
			stmt.setString(6, e.getSalary());
			stmt.setString(7, e.getId());
			stmt.executeUpdate();
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public List<Employee> findAll()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> em = new ArrayList<Employee>();
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "select id,name,gender,birthday,cellphone,email,salary from customer";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getString("id"));
				e.setName(rs.getString("name"));
				e.setGender(rs.getString("gender"));
				e.setBirthday(rs.getDate("birthday"));
				e.setCellphone(rs.getString("cellphone"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getString("salary"));
				em.add(e);
			}
			return em;
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public Employee findEmployeeById(String employeeId)
	{
		if (employeeId == null)
		{
			throw new IllegalArgumentException();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> em = new ArrayList<Employee>();
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "select id,name,gender,birthday,cellphone,email,salary from customer where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employeeId);
			rs = stmt.executeQuery();
			if (rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getString("id"));
				e.setName(rs.getString("name"));
				e.setGender(rs.getString("gender"));
				e.setBirthday(rs.getDate("birthday"));
				e.setCellphone(rs.getString("cellphone"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getString("salary"));
				return e;
			}
			else {
				return null;
			}
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public int getTotalRecords()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "select count(*) from customer";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next())
			{
				return rs.getInt(1);
			}
			else {
				return 0;
			}
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public List<Employee> findPageRecords(int startIndex, int pagesize)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> em = new ArrayList<Employee>();
		try
		{
			conn = JDBCUtil.getConnection();
			String sql = "select id,name,gender,birthday,cellphone,email,salary from customer limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startIndex);
			stmt.setInt(2, pagesize);
			rs = stmt.executeQuery();
			while (rs.next())
			{
				Employee e = new Employee();
				e.setId(rs.getString("id"));
				e.setName(rs.getString("name"));
				e.setGender(rs.getString("gender"));
				e.setBirthday(rs.getDate("birthday"));
				e.setCellphone(rs.getString("cellphone"));
				e.setEmail(rs.getString("email"));
				e.setSalary(rs.getString("salary"));
				em.add(e);
			}
			return em;
		}
		catch (Exception e2)
		{
			throw new DaoException(e2);
		}
		finally
		{
			JDBCUtil.release(rs, stmt, conn);
		}
	}
}
