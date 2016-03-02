package test.concurrent;

/**
 * Java提供了中断机制，要求检查是否中断了，然后决定是不是响应这个中断请求
 */
public class PrimeGenerator extends Thread{

	@Override
	public void run() {
		long num = 1L;
		while(true){
			if(isPrime(num)){
				System.out.println("Number "+num+" is Prime");
			}
			if(isInterrupted()){
				System.out.println("The Prime Generator has been interrupted");
				return ;
			}
			num ++ ;
		}
	}

	private boolean isPrime(long num) {
		if(num <=2){
			return true;
		}
		for (int i = 2; i < num; i++) {
			if(num % i == 0){
				return false ;
			}
		}
		return true ;
	}
	
	public static void main(String[] args) {
		Thread task = new PrimeGenerator() ;
		task.start();
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		task.interrupt();
	}
	

}
