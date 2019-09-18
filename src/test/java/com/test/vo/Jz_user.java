package com.test.vo;

import java.util.Date;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Table.policy;

   /**
    * @文件名称：jz_user.java
    * @创建时间：2019-03-05 11:30:46
    * @创  建  人：林子 
    * @文件描述：jz_user 实体类
    * @文件版本：V0.01 
    */ 

@Table(name="jz_user",type=policy.VO)
public class Jz_user{
	
	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	@Colum(columName="username",isNUll=false,type=ObjTypes.VARCHAR)
	private String username;
	@Colum(columName="password",isNUll=false,type=ObjTypes.VARCHAR)
	private String password;
	@Colum(columName="email",isNUll=false,type=ObjTypes.VARCHAR)
	private String email;
	@Colum(columName="salt",isNUll=false,type=ObjTypes.VARCHAR)
	private String salt;
	@Colum(columName="phone",isNUll=false,type=ObjTypes.VARCHAR)
	private String phone;
	@Colum(columName="linkname",isNUll=false,type=ObjTypes.VARCHAR)
	private String linkname;
	@Colum(columName="usertype",isNUll=false,type=ObjTypes.VARCHAR)
	private String usertype;
	@Colum(columName="createtime",isNUll=false,type=ObjTypes.Date)
	private Date createtime;
	@Colum(columName="modifytime",isNUll=false,type=ObjTypes.Date)
	private Date modifytime;
	@Colum(columName="createby",isNUll=false,type=ObjTypes.VARCHAR)
	private String createby;
	@Colum(columName="modifyby",isNUll=false,type=ObjTypes.VARCHAR)
	private String modifyby;
	@Colum(columName="isdelete",isNUll=false,type=ObjTypes.VARCHAR)
	private Short isdelete;
	
	public void setId(String id){
	this.id=id;
	}
	public String getId(){
		return id;
	}
	public void setUsername(String username){
	this.username=username;
	}
	public String getUsername(){
		return username;
	}
	public void setPassword(String password){
	this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setSalt(String salt){
	this.salt=salt;
	}
	public String getSalt(){
		return salt;
	}
	public void setPhone(String phone){
	this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setLinkname(String linkname){
	this.linkname=linkname;
	}
	public String getLinkname(){
		return linkname;
	}
	public void setUsertype(String usertype){
	this.usertype=usertype;
	}
	public String getUsertype(){
		return usertype;
	}
	public void setCreatetime(Date createtime){
	this.createtime=createtime;
	}
	public Date getCreatetime(){
		return createtime;
	}
	public void setModifytime(Date modifytime){
	this.modifytime=modifytime;
	}
	public Date getModifytime(){
		return modifytime;
	}
	public void setCreateby(String createby){
	this.createby=createby;
	}
	public String getCreateby(){
		return createby;
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

