package co.com.sofka.crud.entities;



import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "tasks")
public final class TaskTodoEntity {
//Tarea
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false )
    private Long id;

    @Column()
    private String name_task;

    @Column()
    private Boolean completed;

    @Column()
    private Long id_list_task;

    public TaskTodoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getId_task() {
        return id_list_task;
    }

    public void setId_task(Long id_list_task) {
        this.id_list_task = id_list_task;
    }
}
