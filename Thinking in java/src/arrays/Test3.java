package arrays;

import java.util.Locale;

public class Test3 {
	public static double[][] twoDoubleArray(int xLen, int yLen, double start, double end) {
		double[][] array = new double[xLen][yLen];
		double increment = (end - start) / (xLen * yLen);
		double val = start;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = val;
				val += increment;
			}
		}
		return array;
	}
	public static void printArray(double[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf(Locale.US, "%.2f ", array[i][j]);
				
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		double[][] twoD = twoDoubleArray(4, 6, 47.0, 99.0);
		printArray(twoD);
		System.out.println("****************************");
		double[][] twoD2 = twoDoubleArray(2, 2, 47.0, 99.0);
		printArray(twoD2);
		System.out.println("****************************");
		double[][] twoD3 = twoDoubleArray(9, 5, 47.0, 99.0);
		printArray(twoD3);
		System.out.println("****************************");
	}
}
