package test;

import java.util.Timer;

public class Test {
	
	public void simpleDelay() {
		System.out.println("Wait 2s...");
		long l1 = System.currentTimeMillis();
		while (System.currentTimeMillis() < l1 + 2000) {
		}
		System.out.println("Done.");
	}
	
	public synchronized void simpleWait() {
		System.out.println("Wait 2s...");
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.");
	}
	
	public synchronized void loopWait() {
		System.out.println("Count from 1 to 5...");
		for (int j = 0; j < 5; j++) {
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(j + 1);
		}
		System.out.println("Done.");
	}
	
	public void testTimer() {
		Timer timer = new Timer();
		TestTimerTask task = new TestTimerTask(timer);
		timer.schedule(task, 2500);
		loopWait();
	}

}
