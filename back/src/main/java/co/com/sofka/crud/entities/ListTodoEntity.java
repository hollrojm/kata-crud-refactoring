package co.com.sofka.crud.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "list_tasks")
public class ListTodoEntity {
//categoria tarea

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String name_list;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_list_task")

    private Set<TaskTodoEntity> tasks;


    public ListTodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameList() {
        return name_list;
    }

    public void setNameList(String nameList) {
        this.name_list = nameList;
    }

    public Set<TaskTodoEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskTodoEntity> tasks) {
        this.tasks = tasks;
    }
}
