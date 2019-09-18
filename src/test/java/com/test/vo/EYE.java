package com.test.vo;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Table.policy;

@Table(name="eye",type=policy.VO)
public class EYE {


	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	@Colum(columName="eye",isNUll=false,type=ObjTypes.VARCHAR)
	private String eye;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEye() {
		return eye;
	}
	public void setEye(String eye) {
		this.eye = eye;
	}
	
	
}
