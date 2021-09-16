package co.com.sofka.crud.DTO;

import javax.persistence.*;
import java.util.Set;


public final class TaskCategoryEntityDTO {

    private Long id;
    private String name;
    private Set<TaskEntityDTO> todos;


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

    public Set<TaskEntityDTO> getTodos() {
        return todos;
    }

    public void setTodos(Set<TaskEntityDTO> todos) {
        this.todos = todos;
    }
}
