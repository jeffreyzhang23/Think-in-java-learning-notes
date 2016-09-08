package arrays;

import java.util.Locale;

public class Test4 {
	public static double[][][] threeDoubleArray(int xLen, int yLen, int zLen, double start, double end) {
		double[][][] array = new double[xLen][yLen][zLen];
		double increment = (end - start) / (xLen * yLen * zLen);
		double val = start;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				for(int k = 0; k < array[i][j].length; k++) {
					array[i][j][k] = val;
					val += increment;
				}
			}
		}
		return array;
	}
	public static void printArray(double[][][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				for(int k = 0; k < array[i][j].length; k++){
					System.out.printf(Locale.US, "%.2f ", array[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		double[][][] twoD = threeDoubleArray(4, 6, 2, 47.0, 99.0);
		printArray(twoD);
		System.out.println("****************************");
		double[][][] twoD2 = threeDoubleArray(2, 2, 5, 47.0, 99.0);
		printArray(twoD2);
		System.out.println("****************************");
		double[][][] twoD3 = threeDoubleArray(9, 5, 7, 47.0, 99.0);
		printArray(twoD3);
		System.out.println("****************************");
	}
}
