package com.in.recharge.bean;

public class RechargeBean {
	private String Name;
	private long MobileNum;
	private String planName;
	private String status;
	private int amount;
	private int RechargeId;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRechargeId() {
		return RechargeId;
	}

	public void setRechargeId(int rechargeId) {
		RechargeId = rechargeId;
	}

	public RechargeBean()
	{
	}
	
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getMobileNum() {
		return MobileNum;
	}
	public void setMobileNum(long mobileNum) {
		MobileNum = mobileNum;
	}
	
}
