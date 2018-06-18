package com.in.recharge.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.in.recharge.bean.RechargeBean;
import com.in.recharge.dao.IRechargeDao;
import com.in.recharge.dao.RechargeDao;

public class RechargeService implements IRecharge{

	@Override
	public String displayPlanDetails() {
		IRechargeDao d = new RechargeDao();
		String str = d.displayPlanDetails();
		return str;
		
	}

	@Override
	public int returnAmount(String planName) {
		IRechargeDao d = new RechargeDao();
		int amt = d.returnAmount(planName);
		return amt;
		
	}
	@Override
	public boolean isValidName(String name) {
		Pattern p = Pattern.compile("^[A-Za-z]{3,}$");
		Matcher matc = p.matcher(name);
		return matc.matches();
	}
	@Override
	public boolean isValidNumber(Long number) {
		Pattern p = Pattern.compile("^[1-9]{1}[0-9]{9}$");
		Matcher m= p.matcher(number.toString());
		return m.matches();
	}
	
	@Override
	public int isValidPlanName(String planName) {
		if(planName.equals("RC99"))
			return 99;
		else if(planName.equals("RC150"))
			return 150;
		else if(planName.equals("RC299"))
			return 299;
		else if(planName.equals("RC500"))
			return 500;
		return 0;
	}

	@Override
	public void addRechargeData(RechargeBean rb) {
		IRechargeDao d = new RechargeDao();
		d.addRechargeData(rb);
	}

	@Override
	public int generateRechargeId() {
		IRechargeDao d = new RechargeDao();
		int res = d.generateRechargeId();
		return res;
	}

	@Override
	public String getDetails(int RechargeId) {
		IRechargeDao d = new RechargeDao();
		String det = d.getDetails(RechargeId);
		return det;
	}

	@Override
	public void createSequence() {
		IRechargeDao d = new RechargeDao();
		d.createSequence();
	}

	@Override
	public void createRechargeTable(RechargeBean rb) {
		IRechargeDao d = new RechargeDao();
		d.createRechargeTable(rb);
		
	}

	
	

}
