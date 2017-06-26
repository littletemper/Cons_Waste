package com.brv.system.util;

import java.util.ResourceBundle;

public class SysUtil
{
	public static String getString(String key)
	{
		ResourceBundle rb = ResourceBundle.getBundle("com.brv.system.util.msg");
		return rb.getString(key);
	}
}
