package containers;

import java.util.PriorityQueue;
import java.util.Random;

class Item implements Comparable<Item> {
	private static final Random rand = new Random(47);
	private Integer priority = rand.nextInt(101);
	@Override
	public int compareTo(Item o) {
		return priority < o.priority ? -1 : (priority == o.priority ? 0 : 1);
	}
	public String toString() {
		return Integer.toString(priority);
	}
}

public class E11_PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Item> p = new PriorityQueue<Item>();
		for(int i = 0; i < 10; i ++) {
			p.add(new Item());
		}
		Item item;
		while((item = p.poll()) != null) {
			System.out.println(item);
		}
	}
}
