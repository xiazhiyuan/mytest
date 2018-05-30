package test.kryo;

/**
 * Created by 123 on 2018/4/13.
 */
public class Test111 {

    public static void main(String[] args) {
        TestA test = new TestB() ;
        test(test);
    }

    public static void test(TestA testA){
        System.out.println("I am TestA");
        testA.print();
    }

    public void test(TestB testB){
        System.out.println("I am TestB");
        testB.print();
    }


}
