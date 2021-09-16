package co.com.sofka.crud.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "task_categories")
public final class TaskCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "taskCat_id")
    private Set<TaskEntity> todos;


    public TaskCategoryEntity() {
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

    public Set<TaskEntity> getTodos() {
        return todos;
    }

    public void setTodos(Set<TaskEntity> todos) {
        this.todos = todos;
    }
}
