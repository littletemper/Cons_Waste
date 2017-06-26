package com.brv.system.exception;

public class LoginException extends RuntimeException
{
	public LoginException()
	{
		super();
	}

	public LoginException(String msg)
	{
		super(msg);
	}
}
