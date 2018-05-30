package test.suanfa;

/**
 * Created by 123 on 2018/4/13.
 */
public class Student {
    private String name;
    private String cource;
    private int score;

    public Student() {
    }

    public Student(String name, String cource, int score) {
        super();
        this.name = name;
        this.score = score;
        this.cource = cource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCource() {

        return cource;
    }

    public int getScore() {
        return score;
    }
}
