package com.in.recharge.pl;

import java.util.Scanner;

import com.in.recharge.bean.RechargeBean;
import com.in.recharge.service.IRecharge;
import com.in.recharge.service.RechargeService;

public class RechargeUserInput {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IRecharge r= new RechargeService();
		RechargeBean rb = new RechargeBean();
		String name = null;
		long mlNum;
		int amount = 0;
		//To validate UserName
		do{
			System.out.println("Enter Valid UserName : ");
			 name = sc.nextLine();
		}while(!(r.isValidName(name)));
		
		
		//To Validate Mobile number
		
		
		do{
			System.out.println("Enter Mobile Number : ");
			mlNum = sc.nextLong();
		}while(!(r.isValidNumber(mlNum)));
		
		
		String planDetails = r.displayPlanDetails();
		System.out.println(planDetails);
		//Validating PlanName
		System.out.println("Enter Plan Name");
		String planName = sc.next();
		if(r.isValidPlanName(planName) != 0)
		{
			amount = r.isValidPlanName(planName);
			rb.setRechargeId(r.generateRechargeId());
			rb.setAmount(amount);
			rb.setStatus("Success");
			rb.setPlanName(planName);
			System.out.println("Your mobile has been recharged succesfully.... Recharge Id is   "+rb.getRechargeId());
		}
		else
		{
			amount = r.isValidPlanName(planName);
			rb.setRechargeId(r.generateRechargeId());
			rb.setPlanName(planName);
			rb.setAmount(amount);
			rb.setStatus("fail");
			
			System.err.println("Your mobile has not been recharged. Plan name is incorrect.");
		}
		
		rb.setMobileNum(mlNum);
		rb.setName(name);
		
		int amt = r.returnAmount(planName);
		System.out.println(amt);
		rb.setAmount(amt);
		
		r.createSequence();
		
		r.createRechargeTable(rb);
		System.out.println(rb.getStatus());
		r.addRechargeData(rb);
		
		System.out.println("Enter your Recharge Id to get the details : ");
		int Id = sc.nextInt();
		String Details = r.getDetails(Id);
		System.out.println(Details);
		
		
	}

}
