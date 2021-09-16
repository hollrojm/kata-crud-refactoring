package co.com.sofka.crud.repositories;


import co.com.sofka.crud.entities.TaskTodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskTodoRepository extends CrudRepository<TaskTodoEntity, Long> {
}
