package arrays;

import java.util.Arrays;

public class MultiDimWrapperArray {
	public static void main(String[] args) {
		Integer[][] a1 = { //Autoboxing
				{1, 2, 3}, 
				{4, 5, 6}
		};
		System.out.println(Arrays.deepToString(a1));
	}
}
