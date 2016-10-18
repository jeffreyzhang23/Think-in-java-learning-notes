package concurrency;

import java.util.concurrent.TimeUnit;

class Daemon2 implements Runnable {
	private Thread[] t = new Thread[10];
	public void run() {
		for(int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started, ");
		}
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch(InterruptedException e) {}
		for(int i = 0; i < t.length; i++) 
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
		while(true) 
			Thread.yield();
	}
}
public class E07_Daemons2 {
	public static void main(String[] args) throws Exception {
		Thread d = new Thread(new Daemon2());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
		TimeUnit.MILLISECONDS.sleep(10);
	}
}
