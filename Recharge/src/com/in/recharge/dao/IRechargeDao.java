package com.in.recharge.dao;

import com.in.recharge.bean.RechargeBean;

public interface IRechargeDao {
	public abstract String displayPlanDetails();
	public abstract int returnAmount(String planName);
	void addRechargeData(RechargeBean rb);
	public abstract int generateRechargeId();
	public abstract String getDetails(int RechargeId);
	public abstract void createSequence();
	public abstract void createRechargeTable(RechargeBean rb);
}
