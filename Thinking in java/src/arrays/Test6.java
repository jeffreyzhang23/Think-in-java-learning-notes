package arrays;

import java.util.Arrays;

public class Test6 {
	static BerylliumSphere[][] fill(int xLen, int yLen) {
		BerylliumSphere[][] array = new BerylliumSphere[xLen][yLen];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = new BerylliumSphere();
			}
		}
		return array;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fill(2, 3)));
	}
}
