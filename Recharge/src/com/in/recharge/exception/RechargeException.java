package com.in.recharge.exception;

public class RechargeException extends Exception{
	String exception_msg;
	public RechargeException(String msg)
	{
		exception_msg = msg;
	}
	public String toString(){
		return exception_msg;
	}
	
	
	
}
