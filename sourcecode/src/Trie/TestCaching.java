package Trie;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;


interface Cacheable {
	Object getIdentifier();
	boolean isExpired();
}
class CacheableObject implements Cacheable {
	Object obj;
	Object id;
	Date dateofExpiration;
	public CacheableObject(Object obj, Object id,int minsToLive) {
		
		this.obj = obj;
		this.id = id;
		if (minsToLive != -1) {
			Date date = new Date();
			Calendar cal =Calendar.getInstance();
			cal.add(Calendar.MINUTE, minsToLive);
			dateofExpiration = cal.getTime();
		}
	
	}
	@Override
	public Object getIdentifier() {
		return id;
	}
	@Override
	public boolean isExpired() {
		if (dateofExpiration == null)
		return false;
		if (new Date().after(dateofExpiration))
			return true;
		return false;
	}
	
}

class CacheManager {
	private HashMap<Object, Cacheable> map = new HashMap<Object, Cacheable>();
	private CacheManager(){
		CacheCleaner cal = new CacheCleaner();
		cal.start();
		
	}
	private static CacheManager instance = null;
	public synchronized static CacheManager getInstance(){
		if (instance == null)
			instance = new CacheManager();
		return instance;
		
	}
	void put(Cacheable obj){
		map.put(obj.getIdentifier(), obj);
	}
	Cacheable get(Object id){
		if (map.containsKey(id))
			return map.get(id);
		return null;
	}

	class CacheCleaner extends Thread {
		public void run() {
			try {
				while (true) {
					Iterator iter = map.keySet().iterator();
					while (iter.hasNext()) {
						Object key = iter.next();
						Cacheable cacheable = map.get(key);
						if (cacheable.isExpired()) {
							iter.remove();
						}

					}
					Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
public class TestCaching {

}
