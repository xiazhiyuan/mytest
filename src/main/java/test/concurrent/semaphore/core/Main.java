package test.concurrent.semaphore.core;

import test.concurrent.semaphore.task.Job;
import test.concurrent.semaphore.task.Job1;
import test.concurrent.semaphore.task.PrintQueue;
import test.concurrent.semaphore.task.PrintQueue1;

/**
 * Main class of the example.
 *
 */
public class Main {

	/**
	 * Main method of the class. Run ten jobs in parallel that
	 * send documents to the print queue at the same time.
	 */
	public static void main (String args[]){
//		print() ;
		print1() ;
		
		
	}
	
	public static void print(){
		// Creates the print queue
		PrintQueue printQueue=new PrintQueue();
		
		// Creates ten Threads
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++){
			thread[i]=new Thread(new Job(printQueue),"Thread "+i);
		}
		
		// Starts the Threads
		for (int i=0; i<10; i++){
			thread[i].start();
		}
	}
	
	public static void print1(){
		// Creates the print queue
		PrintQueue1 printQueue=new PrintQueue1();
		
		// Creates ten Threads
		Thread thread[]=new Thread[12];
		for (int i=0; i<12; i++){
			thread[i]=new Thread(new Job1(printQueue),"Thread "+i);
		}
		
		// Starts the Threads
		for (int i=0; i<12; i++){
			thread[i].start();
		}
	}

}
