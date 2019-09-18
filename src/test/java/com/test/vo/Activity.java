package com.test.vo;

import java.util.Date;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Table.policy;

   /**
    * @文件名称：activity.java
    * @创建时间：2019-03-05 11:30:46
    * @创  建  人：林子 
    * @文件描述：activity 实体类
    * @文件版本：V0.01 
    */ 

@Table(name="activity",type=policy.VO)
public class Activity{
	
	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	
	@Colum(columName="state",isNUll=false,type=ObjTypes.VARCHAR)
	private String state;
	@Colum(columName="activityname",isNUll=false,type=ObjTypes.VARCHAR)
	private String activityname;
	@Colum(columName="orderid",isNUll=false,type=ObjTypes.VARCHAR)
	private String orderid;
	@Colum(columName="activityfirst",isNUll=false,type=ObjTypes.Date)
	private Date activityfirst;
	@Colum(columName="activityend",isNUll=false,type=ObjTypes.Date)
	private Date activityend;
	@Colum(columName="activitymoney",isNUll=false,type=ObjTypes.VARCHAR)
	private String activitymoney;
	@Colum(columName="closeway",isNUll=false,type=ObjTypes.VARCHAR)
	private String closeway;
	@Colum(columName="remarks",isNUll=false,type=ObjTypes.VARCHAR)
	private String remarks;
	@Colum(columName="createtime",isNUll=false,type=ObjTypes.Date)
	private Date createtime;
	@Colum(columName="createby",isNUll=false,type=ObjTypes.VARCHAR)
	private String createby;
	@Colum(columName="modifytime",isNUll=false,type=ObjTypes.Date)
	private Date modifytime;
	@Colum(columName="modifyby",isNUll=false,type=ObjTypes.VARCHAR)
	private String modifyby;
	@Colum(columName="isdelete",isNUll=false,type=ObjTypes.INT)
	private Short isdelete;
	
	
	public void setId(String id){
	this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setState(String state){
	this.state=state;
	}
	public String getState(){
		return state;
	}
	public void setActivityname(String activityname){
	this.activityname=activityname;
	}
	public String getActivityname(){
		return activityname;
	}
	public void setOrderid(String orderid){
	this.orderid=orderid;
	}
	public String getOrderid(){
		return orderid;
	}
	public void setActivityfirst(Date activityfirst){
	this.activityfirst=activityfirst;
	}
	public Date getActivityfirst(){
		return activityfirst;
	}
	public void setActivityend(Date activityend){
	this.activityend=activityend;
	}
	public Date getActivityend(){
		return activityend;
	}
	public void setActivitymoney(String activitymoney){
	this.activitymoney=activitymoney;
	}
	public String getActivitymoney(){
		return activitymoney;
	}
	public void setCloseway(String closeway){
	this.closeway=closeway;
	}
	public String getCloseway(){
		return closeway;
	}
	public void setRemarks(String remarks){
	this.remarks=remarks;
	}
	public String getRemarks(){
		return remarks;
	}
	public void setCreatetime(Date createtime){
	this.createtime=createtime;
	}
	public Date getCreatetime(){
		return createtime;
	}
	public void setCreateby(String createby){
	this.createby=createby;
	}
	public String getCreateby(){
		return createby;
	}
	public void setModifytime(Date modifytime){
	this.modifytime=modifytime;
	}
	public Date getModifytime(){
		return modifytime;
	}
	public void setModifyby(String modifyby){
	this.modifyby=modifyby;
	}
	public String getModifyby(){
		return modifyby;
	}
	public void setIsdelete(Short isdelete){
	this.isdelete=isdelete;
	}
	public Short getIsdelete(){
		return isdelete;
	}
}

