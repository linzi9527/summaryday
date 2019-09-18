package com.test.vo;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Table.policy;

@Table(name="jojo",type=policy.VO)
public class JOJO {

	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	@Colum(columName="jojo",isNUll=false,type=ObjTypes.VARCHAR)
	private String jojo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJojo() {
		return jojo;
	}
	public void setJojo(String jojo) {
		this.jojo = jojo;
	}
	
	
}
