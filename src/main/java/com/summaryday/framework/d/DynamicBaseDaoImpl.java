package com.summaryday.framework.d;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.summaryday.framework.db.DBSetting;
import com.summaryday.framework.db.DynamicDBHelper;

public class DynamicBaseDaoImpl implements IDynamicBaseDao {
	
	private	DynamicDBHelper dbHelper=DynamicDBHelper.getInstance();
	
	public boolean save(DBSetting dBSetting,Object o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.save(dBSetting,o);
		//return ((DBHelper) SpringBeanHelper.getBean("dBHelper")).save(o);
	}

	public boolean update(DBSetting dBSetting,Object o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.update(dBSetting,o);
		//return ((DBHelper) SpringBeanHelper.getBean("dBHelper")).update(o);
	}


	public List<?> queryTables(DBSetting dBSetting,Class<?> c, String[] link_name,String sql,boolean isCache) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.queryTables(dBSetting,c, link_name,sql,isCache);
	}


	public boolean remove(DBSetting dBSetting,Object o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.remove(dBSetting,o);
		//return ((DBHelper) SpringBeanHelper.getBean("dBHelper")).remove(o);
	}


	public boolean delete(DBSetting dBSetting,Integer id,Class<?> o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.delete(dBSetting,id, o);
		//return ((DBHelper) SpringBeanHelper.getBean("dBHelper")).delete(id, o);
	}


	public Object get(DBSetting dBSetting,Integer id, Class<?> o,boolean isCache) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.get(dBSetting,id, o,isCache);
		//return ((DBHelper) SpringBeanHelper.getBean("dBHelper")).get(id, o);
	}


	public boolean CreateTable(DBSetting dBSetting,String sql) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.CreateTable(dBSetting,sql);
	}


	public List<?> queryByOracle(DBSetting dBSetting,Class<?> o, int p1, int p2, String desc)
			throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.queryByOracle(dBSetting,o, p1, p2, desc);
	}


	public List<?> query(DBSetting dBSetting,Class<?> o,boolean isCache) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.find(dBSetting,o,isCache);
	}

	@SuppressWarnings("static-access")
	public List<?> querys(DBSetting dBSetting,Class<?> o,boolean isCache) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.querys(dBSetting,o,isCache);
	}

	public List<?> queryList(DBSetting dBSetting,Class<?> o, String isWhere, boolean isCache)
			throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.queryList(dBSetting,o, isWhere, isCache);
	}

	public Object load(DBSetting dBSetting,Class<?> o, String iswhere,boolean isCache) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.load(dBSetting,o, iswhere, isCache);
	}

	public boolean saveByTransaction(DBSetting dBSetting,Object[] o) throws Exception {
		// TODO Auto-generated method stub
		
		return dbHelper.saveByTransaction(dBSetting,o);
	}

	public Object get(DBSetting dBSetting,String id, Class<?> o, boolean isCache) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.get(dBSetting,id, o, isCache);
	}
	public boolean remove(DBSetting dBSetting,String id,Class<?> o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.delete(dBSetting,id, o);
	}

	public List<?> query(DBSetting dBSetting,Class<?> c, String sql, boolean isCache)
			throws Exception {
		// TODO Auto-generated method stub
		return  dbHelper.query(dBSetting,c, sql, isCache);
	}

	public int executeCUD(DBSetting dBSetting,String sql, Object... obj) {
		// TODO Auto-generated method stub
		return dbHelper.executeUpdate(dBSetting,sql, obj);
	}

	public <E> E query(DBSetting dBSetting,String sql, Class<E> maplistClass,String table,boolean isCache ,Object... obj) {
		// TODO Auto-generated method stub
		return dbHelper.query(dBSetting,sql, maplistClass,table,isCache, obj);
	}

	public <T> List<T> queryList(DBSetting dBSetting,Class<T> resultClass,
			String isWhere,boolean isCache, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return dbHelper.queryList(dBSetting,resultClass, isWhere, isCache,obj);
	}

	public <T> void sortList(List<T> list, String sortField, String sortMode) {
		// TODO Auto-generated method stub
		dbHelper.sortList(list, sortField, sortMode);
	}

	public List<?> queryByList(DBSetting dBSetting,Class<?> resultClass,
			String isWhere, boolean isCache, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return dbHelper.queryByList(dBSetting,resultClass, isWhere, isCache, obj);
	}

	public List<?> queryForList(DBSetting dBSetting,Class<?> Clazz, String sql, Object... obj) throws SQLException  {
		// TODO Auto-generated method stub
		return dbHelper.queryForList(dBSetting,Clazz, sql, obj);
	}

	public String saveForKey(DBSetting dBSetting,Object o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.saveForKey(dBSetting,o);
	}

	//@Override
	public boolean saveUpdate(DBSetting dBSetting,Object o) throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.saveUpdate(dBSetting,o);
	}

	public Map<String, Object> queryMap(DBSetting dBSetting,String sql) {
		// TODO Auto-generated method stub
		return dbHelper.queryMap(dBSetting,sql);
	}

	public List<Map<String, Object>> queryListMap(DBSetting dBSetting,String sql) {
		// TODO Auto-generated method stub
		return dbHelper.queryListMap(dBSetting,sql);
	}

	public boolean deleteByTransaction(DBSetting dBSetting,String id, Class<?> o, String sid,
			Class<?> so) {
		// TODO Auto-generated method stub
		return dbHelper.deleteByTransaction(dBSetting,id, o, sid, so);
	}

	public boolean deleteByTransaction(DBSetting dBSetting,String id, Class<?> o, Integer sid,
			Class<?> so) {
		// TODO Auto-generated method stub
		return dbHelper.deleteByTransaction(dBSetting,id, o, sid, so);
	}

	public boolean deleteByTransaction(DBSetting dBSetting,Integer id, Class<?> o, String sid,
			Class<?> so) {
		// TODO Auto-generated method stub
		return dbHelper.deleteByTransaction(dBSetting,id, o, sid, so);
	}

	public boolean deleteByTransaction(DBSetting dBSetting,Integer id, Class<?> o, Integer sid,
			Class<?> so) {
		// TODO Auto-generated method stub
		return dbHelper.deleteByTransaction(dBSetting,id, o, sid, so);
	}

	public boolean removeByTransaction(DBSetting dBSetting,Object[] obj) {
		// TODO Auto-generated method stub
		return dbHelper.removeByTransaction(dBSetting,obj);
	}

	public boolean updateByTransaction(DBSetting dBSetting,Object[] obj) {
		// TODO Auto-generated method stub
		return dbHelper.updateByTransaction(dBSetting,obj);
	}

	public boolean deleteAfterSaveByTransaction(DBSetting dBSetting,Object delObj, Object saveObj) {
		// TODO Auto-generated method stub
		return dbHelper.deleteAfterSaveByTransaction(dBSetting,delObj, saveObj);
	}

	public boolean deleteAfterUpdateByTransaction(DBSetting dBSetting,Object delObj,
			Object updateObj) {
		// TODO Auto-generated method stub
		return dbHelper.deleteAfterUpdateByTransaction(dBSetting,delObj, updateObj);
	}

	public boolean saveAfterDeleteByTransaction(DBSetting dBSetting,Object saveObj, Object delObj) {
		// TODO Auto-generated method stub
		return dbHelper.saveAfterDeleteByTransaction(dBSetting,saveObj, delObj);
	}

	public boolean saveAfterUpdateByTransaction(DBSetting dBSetting,Object saveObj, Object updateObj) {
		// TODO Auto-generated method stub
		return dbHelper.saveAfterUpdateByTransaction(dBSetting,saveObj, updateObj);
	}

	public boolean updateAfterDeleteByTransaction(DBSetting dBSetting,Object updateObj,
			Object delObj) {
		// TODO Auto-generated method stub
		return dbHelper.updateAfterDeleteByTransaction(dBSetting,updateObj, delObj);
	}

	public boolean updateAfterSaveByTransaction(DBSetting dBSetting,Object updateObj, Object saveObj) {
		// TODO Auto-generated method stub
		return dbHelper.updateAfterSaveByTransaction(dBSetting,updateObj, saveObj);
	}

	public int QueryCount(DBSetting dBSetting,String from_sql) {
		// TODO Auto-generated method stub
		return dbHelper.QueryCount(dBSetting,from_sql);
	}

	@Override
	public boolean multiSQLByTransaction(DBSetting dBSetting,Map<String, Object[]> multiSQL) {
		// TODO Auto-generated method stub
		return dbHelper.multiSQLByTransaction(dBSetting,multiSQL);
	}

	@Override
	public boolean exeCUDByTransaction(DBSetting dBSetting,Object addObj, Object updateObj,
			Object delObj) {
		// TODO Auto-generated method stub
		return dbHelper.exeCUDByTransaction(dBSetting,addObj, updateObj, delObj);
	}

	@Override
	public boolean removeByTransaction(DBSetting dBSetting,String[] ids, Class<?> o) {
		// TODO Auto-generated method stub
		return dbHelper.removeByTransaction(dBSetting,ids, o);
	}

	@Override
	public boolean saveByTransaction(DBSetting dBSetting,Object[] o, String tableName)
			throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.saveByTransaction(dBSetting,o, tableName);
	}

	@Override
	public int executeAndUpdate(DBSetting dBSetting,String sql) {
		// TODO Auto-generated method stub
		return dbHelper.executeAndUpdate(dBSetting,sql);
	}

	@Override
	public int[] createTables(DBSetting dBSetting, List<String> sqlList)
			throws Exception {
		// TODO Auto-generated method stub
		return dbHelper.createTables(dBSetting, sqlList);
	}

	@Override
	public boolean exeCUDByTransaction(DBSetting dBSetting,Object[] objMap) {
		// TODO Auto-generated method stub
		return dbHelper.exeCUDByTransaction(dBSetting, objMap);
	}

	



}
