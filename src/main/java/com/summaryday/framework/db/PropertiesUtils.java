package com.summaryday.framework.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class PropertiesUtils {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
	//private static ResourceBundle  BUNDLE       = ResourceBundle.getBundle("db-ms");
	public static  ResourceBundle BUNDLE_db =null;
	public static boolean Develop_Mode=false;
	public static boolean SQL_FORMAT=false;
	public static boolean JSON_LOG=false;

	public static boolean Is_MS_OPEN=false;//是否开启主从配置
	public static boolean db_Master_W=false;
	private static String loadMessage="";

	static {
		/////////////////////////单库参数配置///////////////////////////////////////
		try {
			BUNDLE_db = ResourceBundle.getBundle("db");
			} catch (Exception e) {
				loadMessage=e.getMessage();
				//logger.error("单库db.properties配置文件加载:"+e.getMessage());
			}

		if(null!=BUNDLE_db){
			logger.info("加载single库配置文件[db.properties], 已开起单库模式...");
			try {
				JSON_LOG=Boolean.parseBoolean(BUNDLE_db.getString("json_log"));
			} catch (Exception e) {
				logger.error("配置文件加载JSON_LOG异常:"+e.getMessage());
			}
			try {
				      SQL_FORMAT=Boolean.parseBoolean(BUNDLE_db.getString("sql_format"));
				      Develop_Mode=Boolean.parseBoolean(BUNDLE_db.getString("develop_mode"));
			} catch (Exception e) {
				logger.error("配置文件加载Develop_Mode,SQL_FORMAT异常:"+e.getMessage());
			}

		}
		
		
	}
}
