package co.com.sofka.crud.entities;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id;

    @Column()
    private String name;

    @Column()
    private boolean completed;

    @Column()
    private Long taskCat_id;

    public TaskEntity() {
    }

    public Long getTaskCat_id() {
        return taskCat_id;
    }

    public void setTaskCat_id(Long taskCat_id) {
        this.taskCat_id = taskCat_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
