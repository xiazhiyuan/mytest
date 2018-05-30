package test.concurrent.threadPrint;

/**
 * Created by 123 on 2018/5/14.
 */
public class PrintNum implements Runnable {
    private Num num ;
    public PrintNum(Num num){
        this.num = num ;
    }
    @Override
    public void run() {
        while (num.num<=100){
            synchronized (num){
                if(num.flag){
                    System.out.println("======1"+":"+num.num);
                    num.num++ ;
                    num.flag = false ;
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
