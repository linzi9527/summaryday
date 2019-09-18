package com.test;

import com.summaryday.framework.db.DBHelper;
import com.summaryday.framework.db.DateUtil;
import com.summaryday.framework.db.StringUtil;
import com.summaryday.framework.db.Table2VOHelper;
import com.test.vo.Activity;
import com.test.vo.EYE;
import com.test.vo.Tbl_order;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.fail;

public class TestSingleDB {

	public static	DBHelper dbHelper;
	
	
	@Before
	public void setUp() throws Exception {
		dbHelper=DBHelper.getInstance();
	}

	@Test
	public void testXX(){
		long f=Runtime.getRuntime().freeMemory();//空闲内存
		long t=Runtime.getRuntime().totalMemory();//总内存
		long m=Runtime.getRuntime().maxMemory();//最大内存
		long c=(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());//已占用的内存
		
		int ff=(int) (f/1024);
		int tt=(int) (t/1024);
		int mm=(int) (m/1024);
		int cc=(int) (c/1024);
		System.out.println(f+"\n"+t+"\n"+m+"\n"+c);
		System.out.println(ff+"M\n"+tt+"M\n"+mm+"M\n"+cc+"M");
		
		Runtime r = Runtime.getRuntime();  
		r.gc();  
		long startMem = r.freeMemory(); // 开始时的剩余内存  
		Object o = new Object();  
		
		long orz = startMem - r.freeMemory(); // 剩余内存 现在 - 开始 = o 的大小 
		System.out.println("=============================\n"+orz);
	}
	
	@Test
	public void test600() {
		Runtime r = Runtime.getRuntime();  
		r.gc();  
		
		long count=0;
		
		List<LeeVO>  list=new ArrayList<LeeVO>();
		long s=	System.currentTimeMillis();
		try {
			long startMem = r.freeMemory(); // 开始时的剩余内存  
			
			for(int i=5000001;i<=(1*5600000);i++){
				LeeVO lee=new LeeVO();
				lee.setFlag("0");
				lee.setId(UUID.randomUUID().toString());
				lee.setLdate(DateUtil.getCurDateTimeSSS());
				lee.setLname("模拟560万第500数据记录第"+i+"条");
				list.add(lee);
				lee=null;
		
				if(i%1000==0){
					long e=	System.currentTimeMillis();
					System.out.println("以达到10万,用时："+(e-s)+"毫秒，即："+(e-s)/1000+"秒");
					long orz = startMem - r.freeMemory(); // 剩余内存 现在 - 开始 = o 的大小 
					System.out.println("=============================\n剩余内存:"+orz+"M\n");
					System.out.println("当前总计:("+list.size()+")条");
					try {
						long ss=	System.currentTimeMillis();
						boolean f=dbHelper.saveByTransaction(list.toArray());
						long ee=	System.currentTimeMillis();
						System.out.println("用时："+(ee-ss)+"毫秒，即："+(ee-ss)/1000+"秒");
						System.out.println("当前总计:("+list.size()+")条");
						count+=list.size();
						if(f)list.clear();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				
			}
		} catch (Exception e) {
			fail("执行过程中异常："+e);
		}
		System.out.println("总计:("+count+")条");
	}
	
	@Test
	public  void findLeeTest() {
		List<TestVO> list=(List<TestVO>) dbHelper.find(TestVO.class, false);
		
		if(null!=list&&list.size()>0){
			for(TestVO u:list){
				System.out.println(u.getId()+"|"+u.getName());
			}
		}else{
			System.out.println("不存在");
		}
	}
	
	@Test
	public  void findLeeVOTest() {
		//List<LeeVO> list=(List<LeeVO>) dbHelper.find(LeeVO.class, false);
		List<Map<String,Object>> list=dbHelper.queryListMap("select * from smarttraining.lee");
		if(null!=list&&list.size()>0){
			for(Map<String,Object> u:list){
				//System.out.println(u.getId()+"|"+u.getLname());
				System.out.println(u);
			}
		}else{
			System.out.println("不存在");
		}
	}
	
	@Test
	public  void createTablesDemoTest() {
		List<String> sqlList=new ArrayList<>();
		for(int i=0;i<10;i++){
			String sql="CREATE TABLE `tbl_test0"+i+"` (" +
					"`id` VARCHAR(50) NOT NULL," +
					"`name` VARCHAR(50) NOT NULL," +
					"PRIMARY KEY (`id`)" +
					") ENGINE=INNODB DEFAULT CHARSET=utf8;";
			sqlList.add(sql);
		}
		
		System.out.println(dbHelper.createTables(sqlList).length);
		
	}
	
	
	@Test
	public  void findDemoTest() {
		Map<String, Object> mapList=dbHelper.queryMap("select id,xy_name,birthday  from smarttraining.lee");
		if(null!=mapList&&mapList.size()>0){
			for (Map.Entry<String, Object> entry : mapList.entrySet()) {
				 System.out.println("key= " + entry.getKey() + " and value= "+ entry.getValue());
			}
		}else{
			System.out.println("不存在");
		}
	}
	
	@Test
	public  void addLeeAndTest() throws Exception {
		for(int i=0;i<1;i++){
			LeeVO  l=new LeeVO();
			l.setId("X0002"+i);
			l.setLname("我是黑警方sirX"+i);
			l.setLdate(DateUtil.getCurDateTime());
			l.setFlag("1");
			dbHelper.save(l);
		}
	}
	
	@Test
	public  void addTrsaction() throws Exception {
		/*JOJO j=new JOJO();
		j.setId("111111111");
		j.setJojo("java");*/
		EYE e=new EYE();
		e.setId("111111111");
		e.setEye("mysql01");
		EYE e1=new EYE();
		e1.setId("222222222");
		e1.setEye("redis01");
		/*Object[] obj=new Object[2];
		obj[0]=e;
		obj[1]=e1;
        System.out.println(dbHelper.saveByTransaction(obj));*/
		EYE[] es=new EYE[2];
		es[0]=e;
		es[1]=e1;
        System.out.println(dbHelper.updateByTransaction(es));
	}
	
	@Test
	public  void queryLeeTest() {
		List<LeeVO> list=(List<LeeVO>) dbHelper.query(LeeVO.class,"select * from smarttraining.lee order by birthday desc", false);
		//System.out.println(JsonUtil.list2json(list));
		if(null!=list&&list.size()>0){
			for(LeeVO u:list){
				System.out.println(u.getId()+"|"+u.getLname()+"|"+u.getLdate());
			}
		}else{
			System.out.println("不存在");
		}
	}
	
	@Test
	public  void queryTest() {
		//queryLeeTest();
		//findLeeTest();
		String bs="name_p",bsTmp=null;
		bsTmp=bs.replaceAll("-","");
		System.out.println(bsTmp);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public  void queryPaymentVOTest() {
	String sql="SELECT a.driving_id as drivingId,a.serial_num as serialNum,a.exam_name as examName,a.pay_money AS payMoney, a.pay_date as payDate,a.pay_cert as payCert,a.start_date as startDate,a.end_date as endDate, format(a.rece_money-a.pay_money,2) as outMoney FROM smarttraining.tbl_payment a,smarttraining.st_cooperation_driving b WHERE a.driving_id=b.id and a.state = '1'";
	
	  List<PaymentVO> list = (List<PaymentVO>) dbHelper.query(PaymentVO.class,sql,false);
	  // dbHelper.queryListMap(sql);
	  System.out.println(list);
	}
	
	@Test
	public  void findTest() {
		Map<String,Object> map0=new HashMap<String,Object>();
		map0.put("C", "userBean");
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("U", "personBean");
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("D", "orderBean");
		
		Object[] objs=new Object[3];
		objs[0]=map0;
		objs[1]=map1;
		objs[2]=map2;
		
		for(int i=0;i<objs.length;i++){
			Map<String,Object> map=(Map<String, Object>) objs[i];
			System.out.println(map);
		}
		
	}
	
	@Test
	public  void Table2VOHelperTest() {
		new Table2VOHelper().setTable2VO("/src/test/java/", "com.test.vo", "tbl_order");
		new Table2VOHelper().setTable2VO("/src/test/java/", "com.test.vo", "activity");
		new Table2VOHelper().setTable2VO("/src/test/java/", "com.test.vo", "jz_user");
	}
	@Test
	public  void findCUDTest() {
		Activity a=new Activity();
		a.setId("1");
		a.setActivitymoney("108.09");
		a.setOrderid("10002");
		a.setActivityfirst(StringUtil.getNowDate());
		a.setActivityend(StringUtil.getNowDate());
		a.setCreatetime(StringUtil.getNowDate());
		a.setModifytime(StringUtil.getNowDate());
		a.setIsdelete((short) 1);
		Tbl_order o=new Tbl_order();
		o.setId("1");
		//o.setPurchase("101.22");
		//o.setState("0");
		
		Tbl_order us=new Tbl_order();
		us.setId("1001");
		us.setPurchase("3022.33");
		us.setState("1");
		/*Jz_user us=new Jz_user();
		us.setId("3");
		us.setEmail("3333@qq.com");
		us.setCreatetime(StringUtil.getNowDate());
		us.setModifytime(StringUtil.getNowDate());
		us.setIsdelete((short) 0);*/
		
		Map<String,Object> map0=new HashMap<String,Object>();
		map0.put("U", a);
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("D", o);
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("C", us);
		
		Object[] objs=new Object[3];
		objs[0]=map0;
		objs[1]=map1;
		objs[2]=map2;
		System.out.println("执行结果:"+dbHelper.exeCUDByTransaction(objs));
	}

}
