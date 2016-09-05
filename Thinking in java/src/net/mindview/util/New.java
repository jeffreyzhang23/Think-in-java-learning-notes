package net.mindview.util;

import java.util.*;

/**
 * 用于创建各种常用的容器对象
 * @author Jeffrey
 * 
 */
public class New {
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
	public static <T> LinkedList<T> lList() {
		return new LinkedList<T>();
	}
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
	//eg:
	Map<String, List<String>> sls = New.map();
	List<String> ls = New.list();
	LinkedList<String> lls = New.lList();
	Set<String> ss = New.set();
}

