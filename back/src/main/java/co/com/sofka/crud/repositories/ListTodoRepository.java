package co.com.sofka.crud.repositories;

import co.com.sofka.crud.entities.TaskTodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListTodoRepository extends CrudRepository<TaskTodoEntity, Long> {
}
