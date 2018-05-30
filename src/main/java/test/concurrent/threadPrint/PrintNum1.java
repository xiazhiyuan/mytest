package test.concurrent.threadPrint;

/**
 * Created by 123 on 2018/5/15.
 */
public class PrintNum1 implements Runnable{
    private Num num ;
    public PrintNum1(Num num){
        this.num = num ;
    }
    @Override
    public void run() {
        while (num.num<=100){
            synchronized (num){
                if(!num.flag){
                    System.out.println("======2"+Thread.currentThread()+":"+num.num);
                    num.num++ ;
                    num.flag = true ;
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
