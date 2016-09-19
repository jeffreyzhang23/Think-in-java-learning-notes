package containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V>{
	static final int SIZE = 997;
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) {
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		}
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		while(it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if(iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		if(!found) {
			buckets[index].add(pair);
		}
		return oldValue;
	}
	
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return null;
		for(MapEntry<K, V> iPair : buckets[index]) {
			if(iPair.getKey().equals(key)) {
				return iPair.getValue();
			}
		}
		return null;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for(LinkedList<MapEntry<K, V>> bucket : buckets) {
			if(bucket == null) continue;
			for(MapEntry<K, V> iPair : bucket) {
				set.add(iPair);
			}
		}
		return set;
	}
	
	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) return null;
		Iterator<MapEntry<K, V>> it = buckets[index].iterator();
		while(it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			if(iPair.getKey().equals(key)) {
				V value = iPair.getValue();
				it.remove();
				return value;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		buckets = new LinkedList[SIZE];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		for(LinkedList<MapEntry<K, V>> bucket : buckets) {
			if(bucket != null) {
				size += bucket.size();
			}
		}
		return size;
	}
	
	public boolean isEmpty() {
		for(LinkedList<MapEntry<K, V>> bucket : buckets) {
			if(bucket != null)
				return false;
		}
		return true;
	}
	
	@Override
	public boolean containsKey(Object key) {
		for(LinkedList<MapEntry<K, V>> bucket : buckets) {
			if(bucket == null) continue;
			for(MapEntry<K, V> mPair : bucket) {
				if(mPair.getKey().equals(key))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
		m.put("CAMEROON", "Yaounde");
		m.put("CONGO", "Brazzaville");
		m.put("CHAD", "N'djamena");
		System.out.println(m);
		System.out.println(m.get("CONGO"));
		System.out.println(m.entrySet());
	}
}
