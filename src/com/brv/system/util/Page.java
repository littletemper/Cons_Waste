package com.brv.system.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<E> implements Serializable
{
	private int totalPage;
	private int currentPage;
	private List<E> result = new ArrayList<E>();

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public List<E> getResult()
	{
		return result;
	}

	public void setResult(List<E> result)
	{
		this.result = result;
	}

}
