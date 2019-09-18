package com.summaryday.framework.db;

import java.io.Serializable;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Table.policy;

@SuppressWarnings("serial")
@Table(name="kuofku_dbconn_setting" ,type=policy.VO)
public class DBSetting implements Serializable{

	@Key(isPrimary=true)
	@Colum(columName="id",isNUll=false,type=ObjTypes.VARCHAR)
	private String id;
	
	@Colum(columName="dbName",isNUll=true,type=ObjTypes.VARCHAR)
	private String dbName;
	
	@Colum(columName="poolType",isNUll=true,type=ObjTypes.VARCHAR)
	private String poolType;
	
	@Colum(columName="dialect",isNUll=true,type=ObjTypes.VARCHAR)
	private String dialect;
	
	@Colum(columName="driver",isNUll=true,type=ObjTypes.VARCHAR)
	private String driver;
	
	@Colum(columName="url",isNUll=true,type=ObjTypes.VARCHAR)
	private String url;
	
	@Colum(columName="username",isNUll=true,type=ObjTypes.VARCHAR)
	private String username;
	
	@Colum(columName="password",isNUll=true,type=ObjTypes.VARCHAR)
	private String password;
	
	@Colum(columName="initialSize",isNUll=true,type=ObjTypes.VARCHAR)
	private String initialSize;
	
	@Colum(columName="minIdle",isNUll=true,type=ObjTypes.VARCHAR)
	private String minIdle;
	
	@Colum(columName="maxActive",isNUll=true,type=ObjTypes.VARCHAR)
	private String maxActive;
	
	@Colum(columName="maxWait",isNUll=true,type=ObjTypes.VARCHAR)
	private String maxWait;
	
	@Colum(columName="timeBetweenEvictionRunsMillis",isNUll=true,type=ObjTypes.VARCHAR)
	private String timeBetweenEvictionRunsMillis;
	
	@Colum(columName="minEvictableIdleTimeMillis",isNUll=true,type=ObjTypes.VARCHAR)
	private String minEvictableIdleTimeMillis;
	
	@Colum(columName="autoCommitOnClose",isNUll=true,type=ObjTypes.VARCHAR)
	private String autoCommitOnClose;
	
	@Colum(columName="testWhileIdle",isNUll=true,type=ObjTypes.VARCHAR)
	private String testWhileIdle;
	
	@Colum(columName="testOnReturn",isNUll=true,type=ObjTypes.VARCHAR)
	private String testOnReturn;
	
	@Colum(columName="testOnBorrow",isNUll=true,type=ObjTypes.VARCHAR)
	private String testOnBorrow;
	
	@Colum(columName="validationQuery",isNUll=true,type=ObjTypes.VARCHAR)
	private String validationQuery;
	
	@Colum(columName="filters",isNUll=true,type=ObjTypes.VARCHAR)
	private String filters;
	
	@Colum(columName="sql_format",isNUll=true,type=ObjTypes.VARCHAR)
	private String sql_format;
	
	@Colum(columName="ehcache",isNUll=true,type=ObjTypes.VARCHAR)
	private String ehcache;
	
	@Colum(columName="develop_mode",isNUll=true,type=ObjTypes.VARCHAR)
	private String develop_mode;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public String getPoolType() {
		return poolType;
	}
	public void setPoolType(String poolType) {
		this.poolType = poolType;
	}
	public String getDialect() {
		return dialect;
	}
	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}
	public String getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}
	public String getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}
	public String getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(String maxWait) {
		this.maxWait = maxWait;
	}
	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	public void setTimeBetweenEvictionRunsMillis(
			String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}
	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}
	public String getAutoCommitOnClose() {
		return autoCommitOnClose;
	}
	public void setAutoCommitOnClose(String autoCommitOnClose) {
		this.autoCommitOnClose = autoCommitOnClose;
	}
	public String getTestWhileIdle() {
		return testWhileIdle;
	}
	public void setTestWhileIdle(String testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public String getTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(String testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public String getTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(String testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public String getValidationQuery() {
		return validationQuery;
	}
	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
	public String getFilters() {
		return filters;
	}
	public void setFilters(String filters) {
		this.filters = filters;
	}
	public String getSql_format() {
		return sql_format;
	}
	public void setSql_format(String sql_format) {
		this.sql_format = sql_format;
	}
	public String getEhcache() {
		return ehcache;
	}
	public void setEhcache(String ehcache) {
		this.ehcache = ehcache;
	}
	public String getDevelop_mode() {
		return develop_mode;
	}
	public void setDevelop_mode(String develop_mode) {
		this.develop_mode = develop_mode;
	}
	
	
	
	
	
}
