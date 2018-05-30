package test.suanfa;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.List;

/**
 * Created by 123 on 2018/4/13.
 */
public class TestCountTimes {
    public static void main(String[] args) {

        //统计 学生中选修课程数为3的学生
        List list = Lists.newArrayList() ;
        Student student1 = new Student() ;
        Student student2 = new Student() ;
        Student student3 = new Student() ;
        Student student4 = new Student() ;
        Student student5 = new Student() ;
        Student student6 = new Student() ;
        Student student7 = new Student() ;
        Student student8 = new Student() ;
        Student student9 = new Student() ;
        Student student10 = new Student() ;

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);

        student1.setName("张三");
        student1.setCource("语文");
        student2.setName("李四");
        student2.setCource("语文");
        student3.setName("李四");
        student3.setCource("数学");
        student4.setName("张三");
        student4.setCource("英语");
        student5.setName("王五");
        student5.setCource("数学");
        student6.setName("张三");
        student6.setCource("历史");

        student7.setName("张二");
        student7.setCource("语文");
        student8.setName("黎明");
        student8.setCource("历史");
        student9.setName("王明");
        student9.setCource("数学");
        student10.setName("马超");
        student10.setCource("历史");

        String aaa = ""  ;
        Multiset set = HashMultiset.create() ;
//        set.
    }
}
