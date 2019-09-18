package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.summaryday.framework.db.DBHelper;
import com.summaryday.framework.db.DBSetting;
import com.summaryday.framework.db.DateUtil;
import com.summaryday.framework.db.DynamicDBHelper;

public class TestChangingOverDB {
	
	private static final Logger log = Logger.getLogger(TestChangingOverDB.class);
	private DBHelper dbHelper;
	
	private DynamicDBHelper dynamicDBHelper;

	@Before
	public void setUp() throws Exception {
		dbHelper = DBHelper.getInstance();
		dynamicDBHelper = DynamicDBHelper.getInstance();
	}
	
	public void tearDown() throws Exception {
		dbHelper = null;
	}
	private String newTableName="car_";
	private String newSQL="CREATE TABLE ";
	private String newContent=" (" +
									"`id` VARCHAR(32) NOT NULL," +
									"`trainId` VARCHAR(32) NOT NULL," +
									"`subTrainId` VARCHAR(32) NOT NULL," +
									"`studentId` VARCHAR(32) NOT NULL," +
									"`carId` VARCHAR(32) NOT NULL," +
									"`lng` VARCHAR(32) NOT NULL," +
									"`lat` VARCHAR(32) NOT NULL," +
									"`angleX` VARCHAR(32) NOT NULL," +
									"`collectionTime` VARCHAR(32) NOT NULL," +
									"PRIMARY KEY (`id`)" +
									") ENGINE=INNODB DEFAULT CHARSET=utf8";
	public List<String> packagingSQL(List<Map<String, Object>> list){
	    List<String> sqlList=new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		
		for(Map<String, Object> map:list){
			String vid=(String)map.get("id");
			sb.append(newSQL)
			.append(newTableName)
			.append(vid).append("_")
			.append(DateUtil.getCurDate().replaceAll("\\-", ""))
			.append(newContent).append(";");
			
			sqlList.add(sb.toString());
			sb.setLength(0);
		}
		//log.info("\n[packagingSQL]:\n"+sb.toString());
		return sqlList;
	}
	
	@Test
	public  void newTableTest() {
		List<String> ids=new ArrayList<String>();
		ids.add("67c383343aa64b929c7642587528e108");
		ids.add("5d58b6981cfb45e087f2f54d94ce2873");
		for(String drivingId:ids){
			String isWhere="where dbName='track_"+drivingId+"'";
			DBSetting dBSetting=(DBSetting) dbHelper.load(DBSetting.class, isWhere, true);
			String vehicleSQL="SELECT id FROM st_s_vehicle WHERE drivingId='"+drivingId+"' AND spare=0";
			List<Map<String, Object>>	list=(List<Map<String, Object>>) dbHelper.queryListMap(vehicleSQL);
			log.info(dynamicDBHelper.createTables(dBSetting,packagingSQL(list)));
		}
			
	}
	
	@Test
	public  void setDataTableTest() {
		for(int n=0;n<4;n++){
			JSONObject jo=JSONObject.fromObject(PostListfile(n));
			String drivingId = jo.getString("drivingId");
			String     carId = jo.getString("carId");
			String   dayDate = jo.getString("dayDate").replaceAll("\\-", "");
			String isWhere="where dbName='track_"+drivingId+"'";
			DBSetting dBSetting=(DBSetting) dbHelper.load(DBSetting.class, isWhere, true);
			String tablename="car_"+carId+"_"+dayDate;
			String dataList=jo.getString("dataList");
			JSONArray jsondataList = JSONArray.fromObject(dataList);
			List<RealInfo> realInfos = JSONArray.toList(jsondataList, RealInfo.class);
			boolean f=dynamicDBHelper.saveByTransaction(dBSetting, realInfos.toArray(), tablename);
			System.out.println(n+"->"+f);
		}
	}
	
	/*@Test
	public  void findDBSettingTest() {
		JSONObject jo=JSONObject.fromObject(PostListfile());
		String drivingId = jo.getString("drivingId");
		String     carId = jo.getString("carId");
		String   dayDate = jo.getString("dayDate").replaceAll("\\-", "");
		String isWhere="where dbName='track_"+drivingId+"'";
		DBSetting dBSetting=(DBSetting) dbHelper.load(DBSetting.class, isWhere, true);
		
		
		
		String tablename="track_"+carId+"_"+dayDate;
		String isTable="SELECT table_name FROM information_schema.TABLES WHERE table_name ='"+tablename+"'";
		
		dynamicDBHelper=DynamicDBHelper.getInstance();
		Map<String,Object> map=dynamicDBHelper.queryMap(dBSetting, isTable);
		if(map.isEmpty()){
			System.out.println(tablename+"，目前不存在！\n 开始创建此表...");
		}else{
			System.out.println(tablename+"，存在！\n 开始批量数据处理...");
		}
		String dataList=jo.getString("dataList");
		//System.out.println(jo.getString("dataList"));
		JSONArray jsondataList = JSONArray.fromObject(dataList);
		List<RealInfo> realInfos = JSONArray.toList(jsondataList, RealInfo.class);
		boolean f=dynamicDBHelper.saveByTransaction(dBSetting, realInfos.toArray(), tablename);
		System.out.println("批量入库："+f);
	}*/
	
	
	public static String PostListfile(int n) {
				JsonObject jo = new JsonObject();
				if(n==0){
					jo.addProperty("drivingId", "5d58b6981cfb45e087f2f54d94ce2873");
					jo.addProperty("carId", "dcb27728496b4d78bbc0e1efa0706278");
				}else if(n==1){
					jo.addProperty("drivingId", "67c383343aa64b929c7642587528e108");
					jo.addProperty("carId", "11aa4e3f7f184d05a9ea839502e95551");
				}else if(n==2){
					jo.addProperty("drivingId", "5d58b6981cfb45e087f2f54d94ce2873");
					jo.addProperty("carId", "dfcd9e0d8f144b278b2bc6ea9fd6778c");
				}else if(n==3){
					jo.addProperty("drivingId", "67c383343aa64b929c7642587528e108");
					jo.addProperty("carId", "148fcc0db611479da12f617b82b9ff5b");
				}
				jo.addProperty("dayDate", "2019-01-14");
				JsonArray arry = new JsonArray();
				for (int i = 0; i <3; i++) {
					JsonObject j = new JsonObject();
					j.addProperty("id", UUID.randomUUID().toString().replaceAll("-", ""));
					j.addProperty("carId", "陕A32C8学");
					j.addProperty("studentId", "oEYBst4yTGDbGqamA67u_LlSIDzI");
					j.addProperty("subTrainId", "d29c5aed8e91410bb20c519c258584a5");
					j.addProperty("trainId", "c2e45cd9b6c4400e9f2b695f7a432f81");
					j.addProperty("lat", "13.2323" + i);
					j.addProperty("lng", "181.2323" + i);
					j.addProperty("angleX", "127.2" + i);
					j.addProperty("collectionTime", DateUtils.getDateTime());
					arry.add(j);
				}
				 jo.add("dataList", arry);
		
		 return jo.toString();

	}
}
