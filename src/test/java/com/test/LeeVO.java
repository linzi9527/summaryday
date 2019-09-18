package com.test;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Table.policy;

@Table(name="smarttraining.lee",type=policy.VO)
public class LeeVO {

	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	
	@Colum(columName="xy_name",isNUll=true,type=ObjTypes.VARCHAR)
	private String lname;
	
	@Colum(columName="birthday",isNUll=true,type=ObjTypes.VARCHAR)
	private String ldate;
	
	@Colum(columName="flag",isNUll=true,type=ObjTypes.VARCHAR)
	private String flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
}
