package test.concurrent.threadPrint;

/**
 * Created by 123 on 2018/5/14.
 */
public class Main {
    public static void main(String[] args) {
        Num num = new Num() ;
        PrintNum printNum = new PrintNum(num) ;
        PrintNum1 printNum1 = new PrintNum1(num) ;
        Thread thread1 = new Thread(printNum) ;
        Thread thread2 = new Thread(printNum1) ;
        thread1.start();
        thread2.start();

    }
}
