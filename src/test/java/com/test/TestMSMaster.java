package com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.summaryday.framework.db.DateUtil;
import com.summaryday.framework.dbms.DBMasterSlaveHelper;
import com.test.vo.EYE;
import com.test.vo.JOJO;

public class TestMSMaster {

public static	DBMasterSlaveHelper dbHelper;
	
	@Before
	public static void setUp() throws Exception {
		dbHelper=DBMasterSlaveHelper.getInstance();
	}

	public  void tearDown() throws Exception {
		dbHelper=null;
	}
	
	@Test
	public  void findTest() {
		List<TestVO> list=(List<TestVO>) dbHelper.find(TestVO.class, false);
		//List<User> list=(List<User>) dbHelper.query(User.class,"select * from demo", false);
		if(null!=list&&list.size()>0){
			for(TestVO u:list){
				System.out.println(u.getId()+"|"+u.getName());
			}
		}else{
			System.out.println("不存在");
		}
	}
	
	public  void addJOJOTest() throws Exception {
		TestVO t=new TestVO();
		t.setId("J0019");
		//t.setJname("我是大sir006");
		//t.setJdate(DateUtil.getCurDateTime());
		
		dbHelper.save(t);
	}
	
	public static void addLeeAndTest() throws Exception {
		/*LeeVO  l=new LeeVO();
		l.setId("X0001");
		l.setLname("我是黑警方sir");
		l.setLdate(DateUtil.getCurDateTime());
		
		TestVO t=new TestVO();
		t.setId("J0020");
		//t.setJname("我是卧底sabllet");
		//t.setJdate(DateUtil.getCurDateTime());
*/		
		JOJO j=new JOJO();
		j.setId("1001");
		j.setJojo("我是jojo");
		
		EYE e=new EYE();
		e.setId("1002");
		e.setEye("我是eye");
		Object[] obj=new Object[2];
		obj[0]=j;
		obj[1]=e;
		dbHelper.saveByTransaction(obj);
	}
	@SuppressWarnings("unchecked")
	@Test
	public  void findLee() {
		List<LeeVO> list=(List<LeeVO>) dbHelper.find(LeeVO.class, false);
		//List<User> list=(List<User>) dbHelper.query(User.class,"select * from demo", false);
		if(null!=list&&list.size()>0){
			for(LeeVO u:list){
				System.out.println(u.getId()+"|"+u.getLname()+"|"+u.getLdate());
			}
		}else{
			System.out.println("不存在");
		}
	}
	public static void main(String[] args) throws Exception {
		setUp();
		//addJOJOTest();
		//findTest();
		addLeeAndTest();
		 // findLee();
	//	String sql="SELECT  COUNT(1) AS CNT  FROM 	ST_DRIVING_SETTING WHERE CURDATE() BETWEEN STARTTIME AND ENDTIME AND DRIVINGID = '1A48FE1D72C7444DA92BD10C2A9D9B90' AND STATE = '1'";
		//  int d = dbHelper.QueryCount(" from st_cooperation_driving where id = '1a48fe1d72c7444da92bd10c2a9d9b90' and state = '1'");
	//	int d = dbHelper.QueryCount(sql);
	//	  System.out.println("dbHelper-d:"+d);
		//LeeVO lo=(LeeVO)dbHelper.load(LeeVO.class, " where id='0c2a1431-ba13-11e7-9179-00163e06052a'", false);
		//LeeVO lo=(LeeVO)dbHelper.get("0c2a1431-ba13-11e7-9179-00163e06052a", LeeVO.class, false);
		//System.out.println(lo.getLname()+","+lo.getFlag());
	}
}
