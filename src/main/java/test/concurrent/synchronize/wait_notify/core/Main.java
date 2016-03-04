package test.concurrent.synchronize.wait_notify.core;

import test.concurrent.synchronize.wait_notify.task.Consumer;
import test.concurrent.synchronize.wait_notify.task.EventStorage;
import test.concurrent.synchronize.wait_notify.task.Producer;

/**
 * Main class of the example
 */
public class Main {

	/**
	 * Main method of the example
	 * wait notify 解决生产者消费者模式
	 */
	public static void main(String[] args) {
		
		// Creates an event storage
		EventStorage storage=new EventStorage();
		
		// Creates a Producer and a Thread to run it
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);

		// Creates a Consumer and a Thread to run it
		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		
		// Starts the thread
		thread2.start();
		thread1.start();
	}

}
