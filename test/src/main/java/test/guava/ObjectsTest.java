package test.guava;

import java.util.Comparator;

import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class ObjectsTest {

    @Test
    public void equalTest() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }

    @Test
    public void equalPersonTest() {
        System.out.println(Objects.equal(new Person("peida", 23), new Person("peida", 23)));
        Person person = new Person("peida", 23);
        System.out.println(Objects.equal(person, person));
    }

    @Test
    public void hashcodeTest() {
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a", "b"));
        System.out.println(Objects.hashCode("b", "a"));
        System.out.println(Objects.hashCode("a", "b", "c"));

        Person person = new Person("peida", 23);
        System.out.println(Objects.hashCode(person));
        System.out.println(Objects.hashCode(person));

    }

    @Test
    public void toStringTest() {
        System.out.println(Objects.toStringHelper(this).add("x", 1).toString());
        System.out.println(Objects.toStringHelper(Person.class).add("x", 1).toString());

        Person person = new Person("peida", 23);
        String result = Objects.toStringHelper(Person.class).add("name", person.name).add("age", person.age).toString();
        System.out.print(result);
    }

    @Test
    public void StudentTest() {

        Student student = new Student("peida", 23, 80);
        Student student1 = new Student("aida", 23, 36);
        Student student2 = new Student("jerry", 24, 90);
        Student student3 = new Student("peida", 23, 80);

        System.out.println("==========equals===========");
        System.out.println(student.equals(student2));
        System.out.println(student.equals(student1));
        System.out.println(student.equals(student3));

        System.out.println("==========hashCode===========");
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(student3.hashCode());
        System.out.println(student2.hashCode());

        System.out.println("==========toString===========");
        System.out.println(student.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        System.out.println("==========compareTo===========");
        System.out.println(student.compareTo(student1));
        System.out.println(student.compareTo(student2));
        System.out.println(student2.compareTo(student1));
        System.out.println(student2.compareTo(student));

    }
}

class Person {

    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Student implements Comparable<Student> {

    public String name;
    public int age;
    public int score;

    Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int compareTo(Student other) {
        return ComparisonChain.start().compare(name, other.name).compare(age, other.age)
                .compare(score, other.score, Ordering.natural().nullsLast()).result();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student that = (Student) obj;
            return Objects.equal(name, that.name) && Objects.equal(age, that.age) && Objects.equal(score, that.score);
        }
        return false;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).addValue(name).addValue(age).addValue(score).toString();
    }

}

class StudentComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
        return ComparisonChain.start().compare(s1.name, s2.name).compare(s1.age, s2.age).compare(s1.score, s2.score)
                .result();
    }
}
