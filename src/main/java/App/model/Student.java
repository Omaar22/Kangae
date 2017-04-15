package App.model;

import javax.persistence.Entity;

@Entity
public class Student extends User{
    private int score = 0;
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
