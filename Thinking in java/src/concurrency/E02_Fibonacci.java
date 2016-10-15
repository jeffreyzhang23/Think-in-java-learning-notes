package concurrency;

import java.util.Arrays;

import net.mindview.util.Generator;

class Fibonacci implements Generator<Integer>, Runnable {
	private int count = 1;
	private final int n;
	Fibonacci(int n) {
		this.n = n;
	}
	public int fib(int n) {
		if(n <= 2) return 1;
		return fib(n - 1) + fib(n -2);
	}
	@Override
	public void run() {
		Integer[] sequence = new Integer[n];
		for(int i = 0; i < n; i++) 
			sequence[i] = next();
		System.out.println("Seq. of " + n + ": " + Arrays.toString(sequence));
	}
	@Override
	public Integer next() {
		return fib(count++);
	}
}
public class E02_Fibonacci {
	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			new Thread(new Fibonacci(i)).start();
		}
	}
}
