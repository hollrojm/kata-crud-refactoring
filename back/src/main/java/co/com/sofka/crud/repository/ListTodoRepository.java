package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.TaskCategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListTodoRepository extends CrudRepository<TaskCategoryEntity, Long> {

}
