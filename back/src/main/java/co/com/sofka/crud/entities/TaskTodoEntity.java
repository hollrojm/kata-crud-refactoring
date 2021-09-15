package co.com.sofka.crud.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tasks_todo_lists")
public class TaskTodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameList;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_id")
    private Set<ListTodoEntity> tasks;

    public TaskTodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public Set<ListTodoEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<ListTodoEntity> tasks) {
        this.tasks = tasks;
    }
}
