package com.test;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;

@Table(name="demo.tbl_test")
public class TestVO {

	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	
	@Colum(columName="name",isNUll=true,type=ObjTypes.VARCHAR)
	private String name;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
