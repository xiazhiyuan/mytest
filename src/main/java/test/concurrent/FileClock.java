package test.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that writes the actual date to a file every second
 * 
 */
public class FileClock implements Runnable {

	/**
	 * Main method of the class
	 */
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				// Sleep during one second
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("The FileClock has been interrupted");
			}
		}
	}
	
	public static void main(String[] args) {
		// Creates a FileClock runnable object and a Thread
		// to run it
		FileClock clock=new FileClock();
		Thread thread=new Thread(clock);
		
		// Starts the Thread
		thread.start();
		try {
			// Waits five seconds
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		// Interrupts the Thread
		thread.interrupt();
	}
}
