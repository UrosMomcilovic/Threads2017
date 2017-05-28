package test;

import java.util.Scanner;
import java.util.Timer;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {
    
    public static final Scanner IN = new Scanner(System.in);
    
    private Singer johnLennon;
    private Singer paulMcCartney;
    
    private void initializeSingingInThreads() {
        String lyrics1 = "I read the news today, oh boy" + '\n' + "...";
        String lyrics2 = '\t' + "Woke up, fell out of bed" + '\n' + '\t' + "...";
        
        Performance firstVoicePerformance = new Performance(lyrics1, 1000);
        Performance secondVoicePerformance = new Performance(lyrics2, 1000);
        
        Synchronizer synch = new Synchronizer(true);
        boolean stopIt = false;
        
        johnLennon = new Singer("John Lennon", Voice.FIRST, firstVoicePerformance, synch, stopIt);
        paulMcCartney = new Singer("PaulMcCartney", Voice.SECOND, secondVoicePerformance, synch, stopIt);
    }
    
    public void testSingInThreads() {
        
        initializeSingingInThreads();
        
        // Here comes the real thing :)
        
        
    }
    
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
