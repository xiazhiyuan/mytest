package test.concurrent.uncaughtException.task;

/**
 * Runnable class than throws and Exception
 *
 */
public class Task implements Runnable {


	/**
	 * Main method of the class
	 */
	public void run() {
		// The next instruction always throws and exception
		int numero=Integer.parseInt("TTT");
	}

}
