package com.summaryday.framework.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactory {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	private static DruidDataSource        dd=null;
	private static  ResourceBundle   BUNDLE =null;
	//private static final ResourceBundle  BUNDLE = ResourceBundle.getBundle("db");
	static {
		try {
			BUNDLE = ResourceBundle.getBundle("db");
			} catch (Exception e) {
				logger.error("配置文件db加载异常:"+e.getMessage());
			}
	}
	
	private static final String        POOLTYPE ="PoolType";
	private static final String          DRIVER = "driver";
	private static final String             URL = "url";
	private static final String        USERNAME = "username";
	private static final String        PASSWORD = "password";
	
	//c3p0
	private static final String      MAXPOOLSIZE="MaxPoolSize";
	private static final String      MINPOOLSIZE="MinPoolSize";
	private static final String   IDLETESTPERIOD="idleConnectionTestPeriod";
	private static final String ACQUIREINCREMENT="acquireIncrement";
	private static final String  INITIALPOOLSIZE="initialPoolSize";
	private static final String    MAXSTATEMENTS="maxStatements";
	private static final String     HELPERTHEADS="numHelperThreads";
	private static final String         IDLETIME="maxIdleTime";
	private static final String    RetryAttempts="acquireRetryAttempts";
	private static final String       RetryDelay="acquireRetryDelay";
	private static final String          TIMEOUT="checkoutTimeout";
	
	
	//druid
	private static final String                            INITIALSIZE="initialSize";
	private static final String                                MINIDLE="minIdle";
	private static final String                              maxActive="maxActive";
	private static final String                                maxWait="maxWait";
	private static final String          timeBetweenEvictionRunsMillis="timeBetweenEvictionRunsMillis";
	private static final String             minEvictableIdleTimeMillis="minEvictableIdleTimeMillis";
	private static final String  maxPoolPreparedStatementPerConnectionSize="maxPoolPreparedStatementPerConnectionSize";
	private static final String                        validationQuery="validationQuery";
	private static final String                                filters="filters";
	private static final String                      AutoCommitOnClose="autoCommitOnClose";
	private static final String              MAXOPENPREPAREDSTATEMENTS="maxOpenPreparedStatements";
	private static final String                 PoolPreparedStatements="poolPreparedStatements";
	private static final String                           TestOnBorrow="testOnBorrow";
	private static final String                           TestOnReturn="testOnReturn";
	private static final String                        RemoveAbandoned="removeAbandoned";
	private static final String                 RemoveAbandonedTimeout="removeAbandonedTimeout";
	private static final String                           LogAbandoned="logAbandoned";
	
	public  static  boolean     EHCACHE=false;
	public  static  String     DIALECT =null;
	public  static  boolean SQL_FORMAT =false;
	public  static  String     PoolType=null;
	public  static  boolean  Develop_Mode=true;//管理开发过程的打印信息，部署时不需求打印信息的控制
	
	ConnectionFactory(){}    


	static {
		
	 if(null!=BUNDLE){
			try {
				PoolType = BUNDLE.getString(POOLTYPE);
			} catch (Exception e) {
				logger.error("获取PoolType异常："+e.getMessage());
			}
	 if(null!=PoolType){		
		try {
			EncryptUtils.isGOTO();
		} catch (Exception e) {
			logger.error("系统检测未能通过安全问题[代码：776]");
		}
		
		try {
			DIALECT=BUNDLE.getString("dialect");
		} catch (Exception e) {
			logger.error("获取dialect异常："+e.getMessage());
		}
		
		try {
			Develop_Mode=Boolean.parseBoolean(BUNDLE.getString("develop_mode"));
		} catch (Exception e1) {
			logger.error("警告:获取develop_mode异常："+e1.getMessage());
		}
		
		if (PoolType!=null&&"druid".equals(PoolType.toLowerCase())) {
		//driud
		 try{
				
				dd = new DruidDataSource();
				dd.setDriverClassName(BUNDLE.getString(DRIVER));
				dd.setUrl(BUNDLE.getString(URL));
				dd.setUsername(BUNDLE.getString(USERNAME));
				dd.setPassword(BUNDLE.getString(PASSWORD));
				
				
				dd.setInitialSize(Integer.parseInt(BUNDLE.getString(INITIALSIZE)));
				dd.setMaxActive(Integer.parseInt(BUNDLE.getString(maxActive)));
				dd.setMinIdle(Integer.parseInt(BUNDLE.getString(MINIDLE)));
				dd.setMaxWait(Integer.parseInt(BUNDLE.getString(maxWait)));

				// 启用监控统计功能
				if (DIALECT!=null&&DIALECT.toLowerCase().indexOf("mysql") > -1){
					// for mysql
						dd.setValidationQuery(BUNDLE.getString(validationQuery));
					}else{
						dd.setPoolPreparedStatements(Boolean.parseBoolean(BUNDLE.getString(PoolPreparedStatements)));
						dd.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(BUNDLE.getString(maxPoolPreparedStatementPerConnectionSize)));
						dd.setMaxOpenPreparedStatements(Integer.parseInt(BUNDLE.getString(MAXOPENPREPAREDSTATEMENTS)));
					}
				
				dd.setFilters(BUNDLE.getString(filters));
				dd.setDefaultAutoCommit(Boolean.parseBoolean(BUNDLE.getString(AutoCommitOnClose)));
				dd.setValidationQuery(BUNDLE.getString(validationQuery));
				dd.setMinEvictableIdleTimeMillis(Integer.parseInt(BUNDLE.getString(minEvictableIdleTimeMillis)));
				dd.setTimeBetweenEvictionRunsMillis(Integer.parseInt(BUNDLE.getString(timeBetweenEvictionRunsMillis)));
				dd.setTestWhileIdle(Boolean.parseBoolean(BUNDLE.getString("testWhileIdle")));
				dd.setTestOnReturn(Boolean.parseBoolean(BUNDLE.getString(TestOnReturn)));
				dd.setTestOnBorrow(Boolean.parseBoolean(BUNDLE.getString(TestOnBorrow)));
				try {
					//超过时间限制是否回收
					dd.setRemoveAbandoned(Boolean.parseBoolean(BUNDLE.getString(RemoveAbandoned)));
					//超时时间；单位为秒。180秒=3分钟
					dd.setRemoveAbandonedTimeout(Integer.parseInt(BUNDLE.getString(RemoveAbandonedTimeout)));
					//关闭abanded连接时输出错误日志
					dd.setLogAbandoned(Boolean.parseBoolean(BUNDLE.getString(LogAbandoned)));
					//超过180s，强制回收数据库连接，回收的时候打印日志，日志中会显示代码中没有释放数据库连接的代码具体位置
				} catch (Exception e) {
					logger.error("参数[RemoveAbandoned,RemoveAbandonedTimeout,LogAbandoned]转换异常:"+e.getMessage());
				}
				
				ConnectionFactory.DIALECT    = BUNDLE.getString("dialect");
				ConnectionFactory.SQL_FORMAT = Boolean.parseBoolean(BUNDLE.getString("sql_format"));
				ConnectionFactory.EHCACHE    = Boolean.parseBoolean(BUNDLE.getString("ehcache"));
				logger.info("\n"+
						"=====================================\n"+
						"‖             druid初始化            ‖\n"+
						"=====================================\n"
						+"\n");
		} catch (Exception e) {
			logger.error("\n druid 数据源连接池初始化异常："+e.getMessage());
		}
      }
	 }//if type
		else{logger.info("未开启主库db配置参数");}	
  }//if BUNDLE		
}//static

	
	public static synchronized Connection getConnection() {
	//	public static synchronized Connection getConnection() {
	        Connection con = null;
	        long s=System.currentTimeMillis();
	        try {
	        	if(EncryptUtils.LOCK){
		        	 if(PoolType!=null&&"druid".equals(PoolType.toLowerCase())){
		            	con=dd.getConnection();
		            }
	        	}else{
					logger.error("系统检测未能通过安全问题[代码：777]");
	        	}
	        } catch (SQLException e1) {
	        	logger.error("\n 连接池--获取数据库连接异常："+e1.getMessage());
	        }
	        long e=System.currentTimeMillis();
	        logger.info("耗时:"+(e-s));
	        return con;
	    }

		public static String getDialect() {
			return DIALECT;
		}
	    
	    public static Boolean getSqlFormat() {
			return SQL_FORMAT;
		}

	    private static ConnectionFactory instance;
	    
	    public static ConnectionFactory getInstance() {
			
	        if (instance == null&&EncryptUtils.LOCK) {
	            synchronized (ConnectionFactory.class) {
	                if(instance == null) {
	                    instance = new ConnectionFactory();
	                }
	                logger.info("\n"+
							"=========================================================================\n"+
							"‖  数据源实例化                                                           ‖\n"+
							"‖  "+instance+"	 	‖\n"+
							"=========================================================================\n"
							+"\n");
	            }
	        }
	        return instance;
	    }
	     
	   
} // C3P0 end
