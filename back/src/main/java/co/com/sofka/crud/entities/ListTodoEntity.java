package co.com.sofka.crud.entities;



import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "tasks_todo_list")
public final class ListTodoEntity {

    @Id
    private Long id;
    private String nameTask;
    @OneToMany (cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<TaskTodoEntity> task;
    private boolean completed;



    public ListTodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public Set<TaskTodoEntity> getTask() {
        return task;
    }

    public void setTask(Set<TaskTodoEntity> task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
