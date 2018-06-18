package com.in.recharge.dao;

public interface IQueryMapper {
	public static final String RETURN_AMOUNT = "Select amount from rechargeplans where planname=?" ;
	public static final String ADD_RECHARGE_DATA = "INSERT INTO recharge_det VALUES(?,?,?,?,?,?)";
	public static final String GET_RECHARGE_DETAILS = "Select * from recharge_det where  rechargeId =?";
	public static final String GENERATE_ID = "select Rec_seq.NEXTVAL from dual";
	public static final String DISPLAY_PLAN_DETAILS = "Select * from rechargeplans";
	public static final String CREATE_SEQ = "CREATE SEQUENCE Rec_seq "
			+ "START WITH 2"
			+ "INCREMENT BY 1"
			+ "NOCYCLE";
	public static final String CREATE_RECHARGE_DETAILS_TABLE = " create table recharge_det(rechargeId number,UserName varchar2(10), MobileNumber number, status varchar2(10),planName varchar2(5),amount number)";
}
