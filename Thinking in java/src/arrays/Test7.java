package arrays;

import java.util.Arrays;

public class Test7 { //test
	static BerylliumSphere[][][] fill(int xLen, int yLen, int zLen) {
		BerylliumSphere[][][] array = new BerylliumSphere[xLen][yLen][zLen];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				for(int k = 0; k < array[i][j].length; k++) {
					array[i][j][k] = new BerylliumSphere();
				}
			}
		}
		return array;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fill(2, 3, 4)));
	}
}
