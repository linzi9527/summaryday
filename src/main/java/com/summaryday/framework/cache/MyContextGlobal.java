package com.summaryday.framework.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyContextGlobal {
	
	 private static final Map<String, Object> MAP=new HashMap<String, Object>();
	 private static final List<Object> LIST=new ArrayList<Object>();
	 
	 
	 
	 private static final ThreadLocal<Map<Object, Object>> mycontext = new ThreadLocal<Map<Object, Object>>() {
	        @Override
	        protected Map<Object, Object> initialValue() {
	            return new HashMap<Object, Object>();
	        }
	 
	    };

	    /**
	     * 根据key获取值
	     * @param key
	     * @return
	     */
	    public static Object getValue(Object key) {
	        if(mycontext.get() == null) {
	            return null;
	        }
	        return mycontext.get().get(key);
	    }
	 
	    /**
	     * 存储
	     * @param key
	     * @param value
	     * @return
	     */
	    public static Object setValue(Object key, Object value) {
	        Map<Object, Object> cacheMap = mycontext.get();
	        if(cacheMap == null) {
	            cacheMap = new HashMap<Object, Object>();
	            mycontext.set(cacheMap);
	        }
	        return cacheMap.put(key, value);
	    }
	 
	    /**
	     * 根据key移除值
	     * @param key
	     */
	    public static void removeValue(Object key) {
	        Map<Object, Object> cacheMap = mycontext.get();
	        if(cacheMap != null) {
	            cacheMap.remove(key);
	        }
	    }
	 
	    /**
	     * 重置
	     */
	    public static void reset() {
	        if(mycontext.get() != null) {
	            mycontext.get().clear();
	        }
	    }

	
}
