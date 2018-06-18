package com.in.recharge.service;

import com.in.recharge.bean.RechargeBean;

public interface IRecharge {
	public abstract String displayPlanDetails();
	public abstract int returnAmount(String planName);
	public abstract boolean isValidName(String name);
	public abstract boolean isValidNumber(Long number);
	public abstract int isValidPlanName(String planName);
	void addRechargeData(RechargeBean rb);
	public abstract int generateRechargeId();
	public abstract String getDetails(int RechargeId);
	public abstract void createSequence();
	public abstract void createRechargeTable(RechargeBean rb);
}
