package App.model;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    @JoinColumn (name = "name", table = "Teacher")
    private String teacherName;

    public Course() {
    }

    public Course(String teacherName) {
        this.teacherName = teacherName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

}
