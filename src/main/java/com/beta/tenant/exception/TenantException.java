package com.beta.tenant.exception;
//it is a class which extends the exception class
public class TenantException extends Exception {

	//contructor with field
	public TenantException(String message)
	{
		super(message);
	}

	public TenantException()
	{
		super();
	}
}
