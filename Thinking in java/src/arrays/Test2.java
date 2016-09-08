package arrays;

import java.util.Arrays;

public class Test2 {
	static BerylliumSphere[] retArray(int n) {
		if(n <= 0) return null;
		BerylliumSphere[] b = new BerylliumSphere[n];
		for(int i = 0; i < n; i++) {
			b[i] = new BerylliumSphere();
		}
		return b;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(retArray(10)));
	}
	
}
