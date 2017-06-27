package com.brv.project.persist;

import java.util.List;

import com.brv.system.domian.ItemInfo;
import com.brv.system.domian.Project;

public interface ItemInfoDao
{
    public void insertItemInfo(ItemInfo i);
	
	public Project findItemByPId(Integer pId);
	
	public List<Project> findAllItem();

}
