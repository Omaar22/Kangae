package App.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    private String description;
    private String instruction;
//    @ManyToOne
//    @JoinColumn(name = "id", table = "Course")
    private long courseID;

    public Game() {
    }

    public Game(long id, String name, String description, String instruction, long courseID) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.instruction = instruction;
        this.courseID = courseID;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }
}
