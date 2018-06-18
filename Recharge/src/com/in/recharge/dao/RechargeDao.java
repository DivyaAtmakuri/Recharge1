package com.in.recharge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.in.recharge.bean.RechargeBean;
import com.in.recharge.exception.RechargeException;
import com.in.recharge.util.DBConnection;

public class RechargeDao implements IRechargeDao{
	Logger logger=Logger.getRootLogger();
	public RechargeDao()
	{
	PropertyConfigurator.configure("Resources//log4j.properties");
	
	}
	
	
	
	
	
	StringBuilder sb = new StringBuilder();
	int res = 0;
	
	
	
	
	@Override
	public String displayPlanDetails() {
		try{
			 
			Connection con1 = DBConnection.getConnection();
			Statement stmt=con1.createStatement(); 
			
			ResultSet rs = stmt.executeQuery(IQueryMapper.DISPLAY_PLAN_DETAILS);
			while(rs.next()){
				sb.append(rs.getString(1)+"   "+rs.getInt(2)+"\n");
			}
			con1.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return sb.toString();
	}
	
	
	
	
	
	@Override
	public int returnAmount(String planName) {
		int amt = 0;
		try{
			 
			Connection con1 = DBConnection.getConnection();  
			Statement stmt=con1.createStatement(); 
			
			ResultSet rs = stmt.executeQuery("Select amount from rechargeplans where planname='"+planName+"'");
			while(rs.next()){
				amt = rs.getInt(1);
			}
			con1.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return amt;
	}
	
	
	
	
	
	
	@Override
	public int generateRechargeId() {
		try{  
			Connection con1 = DBConnection.getConnection();
			Statement stmt1=con1.createStatement(); 
			ResultSet rs = stmt1.executeQuery(IQueryMapper.GENERATE_ID);
			rs.next();
			res = rs.getInt(1);
			con1.close();
		}catch(Exception e){ 
			String msg = e.getMessage();
			System.out.println(msg);
		}
		
		return res;
	}
	
	
	
	@Override
	public void addRechargeData(RechargeBean rb) {
		try{  
			Connection con1 = DBConnection.getConnection();
			PreparedStatement stmt1=con1.prepareStatement(IQueryMapper.ADD_RECHARGE_DATA);  
			logger.info("Values getting inserted into the table");
			
			stmt1.setInt(1,rb.getRechargeId());
			stmt1.setString(2,rb.getName());
			stmt1.setLong(3,rb.getMobileNum());
			stmt1.setString(4,rb.getStatus());
			stmt1.setString(5,rb.getPlanName());
			stmt1.setInt(6,rb.getAmount());
			stmt1.execute();
					
				
			//step5 close the connection object  
			con1.close();  
			  
			}catch(Exception e){ 
				String msg = e.getMessage();
				System.out.println(msg);
			}
	}


	
	
	
	@Override
	public String getDetails(int RechargeId) {
		int rechargeId = 0;
		String UserName;
		Long mobileNum;
		String status;
		String planName;
		int amount;
		try{  
			Connection con1 = DBConnection.getConnection();
			PreparedStatement ps = con1.prepareStatement(IQueryMapper.GET_RECHARGE_DETAILS);
			ps.setInt(1,RechargeId);
			ResultSet rs = ps.executeQuery();
			logger.debug("Extracting details based on the selected recharge Id");
			rs.next();
				rechargeId = rs.getInt(1);
				UserName = rs.getString(2);
				mobileNum = rs.getLong(3);
				status = rs.getString(4);
				planName = rs.getString(5);
				amount = rs.getInt(6);
				sb.append("Recharge Id : "+rechargeId+"\nUser Name : "+UserName +"\nMobile number : "+mobileNum+"\nStatus : "+status+"\nPlan Name : "+planName+"\nAmount : "+amount);
				con1.close();
		}catch(Exception e){ 
			String msg = e.getMessage();
			System.out.println(msg);
		}
		return sb.toString();
	}






	@Override
	public void createSequence() {
		try{  
			//step1 load the driver class  
			Connection con1 = DBConnection.getConnection();
			PreparedStatement stmt = con1.prepareStatement("select count(*) from user_sequences where sequence_name ='REC_SEQ'");
			ResultSet rs1 = stmt.executeQuery();
			rs1.next();
			if(rs1.getInt(1) >= 1)
			{
				throw new RechargeException("Sequence already exists");
			}
			else {
				stmt = con1.prepareStatement(IQueryMapper.CREATE_SEQ);
				ResultSet rs = stmt.executeQuery();
				rs.next();
			}
			con1.close();
		}
		catch(RechargeException re)
		{
			System.out.println(re);
		}
		catch(Exception e){ 
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}






	@Override
	public void createRechargeTable(RechargeBean rb) {
		try{  
			Connection con1 = DBConnection.getConnection();
			PreparedStatement stmt = con1.prepareStatement("select count(*) from tab where tname ='RECHARGE_DET'");
			ResultSet rs1 = stmt.executeQuery();
			rs1.next();
			if(rs1.getInt(1) >= 1)
			{
				logger.error("Table Already exist. Table with same name cannot be created");
				throw new RechargeException("Table already exists");
			}
			else {
				PreparedStatement stmt1=con1.prepareStatement(IQueryMapper.CREATE_RECHARGE_DETAILS_TABLE);
				ResultSet rs = stmt1.executeQuery();
			}
		}
		catch(RechargeException re)
		{
			System.out.println(re);
		}
		catch(Exception e){ 
			String msg = e.getMessage();
			System.out.println(msg);
		}		
	}
	
	

}
