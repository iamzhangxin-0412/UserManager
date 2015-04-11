package com.zhangbin.web.formbean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class EmployeeFormBean
{
	private String id;
	private String name;
	private String gender;   //1 男 0 女
	private String birthday;
	private String cellphone;
	private String email;
	private String salary;
	private Map<String, String> errors = new HashMap<String, String>();
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getBirthday()
	{
		return birthday;
	}
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	public String getCellphone()
	{
		return cellphone;
	}
	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getSalary()
	{
		return salary;
	}
	public void setSalary(String salary)
	{
		this.salary = salary;
	}
	public Map<String, String> getErrors()
	{
		return errors;
	}
	public boolean validate(){
		//验证日期是否正确
		if(birthday==null&&"".equals(birthday.trim().toString())){
			errors.put("birthday", "日期必须得输入");
		}else{
			try{
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(birthday);
			}catch(Exception e){
				errors.put("birthday", "要输就请输入正确地");
			}
		}
		
		return errors.isEmpty();
	}
}
