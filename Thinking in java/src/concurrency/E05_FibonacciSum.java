package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.mindview.util.Generator;

class FibonacciSum 
implements Generator<Integer>,  Callable<Integer> {
	private int count;
	private final int n;
	public FibonacciSum(int n) {
		this.n = n;
	}
	private int fib(int n) {
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += next();
		}
		return sum;
	}
	@Override
	public Integer next() {
		return fib(count++);
	}
}
public class E05_FibonacciSum {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> results = new ArrayList<>();
		for(int i = 1; i <= 5; i++) {
			results.add(exec.submit(new FibonacciSum(i)));
		}
		Thread.yield();
		exec.shutdown();
		for(Future<Integer> fi : results) {
			try {
				System.out.println(fi.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
