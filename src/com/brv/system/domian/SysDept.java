package com.brv.system.domian;

import java.io.Serializable;

public class SysDept implements Serializable
{
	private static final long serialVersionUID = 6441236564732129235L;
	private Integer deptId;
	private String deptName;

	public Integer getDeptId()
	{
		return deptId;
	}

	public void setDeptId(Integer deptId)
	{
		this.deptId = deptId;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

}
