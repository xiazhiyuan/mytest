package test.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that simulates an initialization operation. It sleeps during four seconds
 * 当一个线程对象的join()方法被调用时，调用它的线程将被挂起，直到这个线程对象完成它的任务
 */
public class DataSourcesLoader implements Runnable {


	/**
	 * Main method of the class
	 */
	public void run() {
		
		// Writes a messsage
		System.out.printf("Begining data sources loading: %s\n",new Date());
		// Sleeps four seconds
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Writes a message
		System.out.printf("Data sources loading has finished: %s\n",new Date());
	}
	
	
	public static void main(String[] args) {
		// Creates and starts a DataSourceLoader runnable object
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader,"DataSourceThread");
		thread1.start();

		// Creates and starts a NetworkConnectionsLoader runnable object
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
		thread2.start();

		// Wait for the finalization of the two threads
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Waits a message
		System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
	}
}
