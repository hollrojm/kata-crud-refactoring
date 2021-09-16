package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
