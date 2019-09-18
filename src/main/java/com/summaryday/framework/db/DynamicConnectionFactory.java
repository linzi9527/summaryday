package com.summaryday.framework.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DynamicConnectionFactory {
	private static final Logger logger = LoggerFactory.getLogger(DynamicConnectionFactory.class);

	private static DruidDataSource        dd=null;
	
	public  static  boolean     EHCACHE=false;
	public  static  String     DIALECT =null;
	public  static  boolean SQL_FORMAT =false;
	public  static  String     PoolType=null;
	public  static  boolean  Develop_Mode=true;//管理开发过程的打印信息，部署时不需求打印信息的控制
	
	DynamicConnectionFactory(){}    


	public static boolean init(DBSetting dbsetting) {
		try {
			EncryptUtils.isGOTO();
		} catch (Exception e) {
			System.out.println("安全-注册失效，服务会受影响！");
		}
		PoolType =dbsetting.getPoolType();
		  DIALECT=dbsetting.getDialect();
		  
		  try {
			Develop_Mode=StringUtil.StringToBoolean(dbsetting.getDevelop_mode());
		} catch (Exception e1) {
			logger.error("警告:获取develop_mode异常："+e1.getMessage());
		}
		  
		
		//driud
		 try{
				dd = new DruidDataSource();
				dd.setDriverClassName(dbsetting.getDriver());
				dd.setUrl(dbsetting.getUrl());
				dd.setUsername(dbsetting.getUsername());
				dd.setPassword(dbsetting.getPassword());
				
				dd.setInitialSize(StringUtil.StringToInteger(dbsetting.getInitialSize()));
				dd.setMaxActive(StringUtil.StringToInteger(dbsetting.getMaxActive()));
				dd.setMinIdle(StringUtil.StringToInteger(dbsetting.getMinIdle()));
				dd.setMaxWait(StringUtil.StringToInteger(dbsetting.getMaxWait()));

				// 启用监控统计功能
				dd.setValidationQuery(dbsetting.getValidationQuery());
				
				dd.setFilters(dbsetting.getFilters());
				dd.setDefaultAutoCommit(StringUtil.StringToBoolean(dbsetting.getAutoCommitOnClose()));
				dd.setMinEvictableIdleTimeMillis(StringUtil.StringToInteger(dbsetting.getMinEvictableIdleTimeMillis()));
				dd.setTimeBetweenEvictionRunsMillis(StringUtil.StringToInteger(dbsetting.getTimeBetweenEvictionRunsMillis()));
				dd.setTestWhileIdle(StringUtil.StringToBoolean(dbsetting.getTestWhileIdle()));
				dd.setTestOnReturn(StringUtil.StringToBoolean(dbsetting.getTestOnReturn()));
				dd.setTestOnBorrow(StringUtil.StringToBoolean(dbsetting.getTestOnBorrow()));
				
				DynamicConnectionFactory.DIALECT    = dbsetting.getDialect();
				DynamicConnectionFactory.SQL_FORMAT = StringUtil.StringToBoolean(dbsetting.getSql_format());
				DynamicConnectionFactory.EHCACHE    = StringUtil.StringToBoolean(dbsetting.getEhcache());
				logger.info("\n"+
						"=====================================\n"+
						"‖      druid初始化:"+dd+"\n"+
						"=====================================\n"
						+"\n");
		} catch (Exception e) {
			logger.error("\n druid 数据源连接池初始化异常："+e.getMessage());
			return false;
		}
     
		return true;
	}	

	
	public static synchronized Connection getConnection() {
	        Connection conn = null;
	        long s=System.currentTimeMillis();
	        try {
	        	if(EncryptUtils.LOCK){
	        		conn=dd.getConnection();
	        	}else{
	        		System.out.println("系统为了系统安全，服务暂停！");
	        	}
	        } catch (SQLException e1) {
	        	logger.error("\n 连接池--获取数据库连接异常："+e1.getMessage());
	        }
	        long e=System.currentTimeMillis();
	        logger.info("获取数据库连接-耗时:"+(e-s)+"毫秒");
	        return conn;
	    }

		public static String getDialect() {
			return DIALECT;
		}
	    
	    public static Boolean getSqlFormat() {
			return SQL_FORMAT;
		}

	    
	    //private static Map<String,DynamicConnectionFactory> instance_MAP=new HashMap<String,DynamicConnectionFactory>();
	    
	    public static DynamicConnectionFactory getInstance(DBSetting dbsetting) {
	    	DynamicConnectionFactory  instance =null;
	    	if(instance== null){
	    		synchronized (DynamicConnectionFactory.class) {
	                if(instance== null) {
	                	instance = new DynamicConnectionFactory();
	                    init(dbsetting);//初始化参数完成
	                }
	                logger.info("\n"+
							"=========================================================================\n"+
							"‖                                                            数据源实例化(初次)                                                                   ‖\n"+
							"‖                   "+instance+"‖\n"+
							"=========================================================================\n"
							+"\n");
	            }
	    	}
	    	return instance;
	    }
	     
	   
}
