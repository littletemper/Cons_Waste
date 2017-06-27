package com.brv.project.service;


import com.brv.project.persist.ItemInfoDao;
import com.brv.project.persist.ItemInfoDaoImpl;
import com.brv.system.domian.ItemInfo;

public class ItemServiceImpl implements ItemService
{
	private ItemInfoDao id=new ItemInfoDaoImpl();
	
	@Override
	public void addItemInfo(ItemInfo i)
	{
		id.insertItemInfo(i);
		
	}

}
