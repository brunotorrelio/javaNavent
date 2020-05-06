package com.brunotorrelio.testnavent.cache;

import java.util.HashMap;
import java.util.Map;

public class BumexMemcached {
	
	private static Map<String, Object> map;
	
	private BumexMemcached() {
		map = new HashMap<String, Object>();
	}
	
	private static class SingletonHelper {
		private static final BumexMemcached INSTANCE = new BumexMemcached();
	}
	
	public static BumexMemcached getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public void set(String key, Object value) {
		map.put(key, value);
	}
	
	public Object get(String key) {
		return map.get(key);
	}
	
	public void delete(String key) {
		map.remove(key);
	}
	
}
