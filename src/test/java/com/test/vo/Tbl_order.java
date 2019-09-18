package com.test.vo;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Table.policy;

   /**
    * @文件名称：tbl_order.java
    * @创建时间：2019-03-05 11:30:46
    * @创  建  人：林子 
    * @文件描述：tbl_order 实体类
    * @文件版本：V0.01 
    */ 

@Table(name="tbl_order",type=policy.VO)
public class Tbl_order{
	
	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	@Colum(columName="ordername",isNUll=false,type=ObjTypes.VARCHAR)
	private String ordername;
	@Colum(columName="orderfirst",isNUll=false,type=ObjTypes.VARCHAR)
	private String orderfirst;
	@Colum(columName="orderend",isNUll=false,type=ObjTypes.VARCHAR)
	private String orderend;
	@Colum(columName="closeway",isNUll=false,type=ObjTypes.VARCHAR)
	private String closeway;
	@Colum(columName="purchase",isNUll=false,type=ObjTypes.VARCHAR)
	private String purchase;
	@Colum(columName="createtime",isNUll=false,type=ObjTypes.VARCHAR)
	private String createtime;
	@Colum(columName="state",isNUll=false,type=ObjTypes.VARCHAR)
	private String state;
	@Colum(columName="remarks",isNUll=false,type=ObjTypes.VARCHAR)
	private String remarks;
	
	
	public void setId(String id){
	this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setOrdername(String ordername){
	this.ordername=ordername;
	}
	public String getOrdername(){
		return ordername;
	}
	public void setOrderfirst(String orderfirst){
	this.orderfirst=orderfirst;
	}
	public String getOrderfirst(){
		return orderfirst;
	}
	public void setOrderend(String orderend){
	this.orderend=orderend;
	}
	public String getOrderend(){
		return orderend;
	}
	public void setCloseway(String closeway){
	this.closeway=closeway;
	}
	public String getCloseway(){
		return closeway;
	}
	public void setPurchase(String purchase){
	this.purchase=purchase;
	}
	public String getPurchase(){
		return purchase;
	}
	public void setCreatetime(String createtime){
	this.createtime=createtime;
	}
	public String getCreatetime(){
		return createtime;
	}
	public void setState(String state){
	this.state=state;
	}
	public String getState(){
		return state;
	}
	public void setRemarks(String remarks){
	this.remarks=remarks;
	}
	public String getRemarks(){
		return remarks;
	}
}

