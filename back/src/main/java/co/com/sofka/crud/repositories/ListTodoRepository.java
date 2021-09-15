package co.com.sofka.crud.repositories;

import co.com.sofka.crud.entities.ListTodoEntity;

import org.springframework.data.repository.CrudRepository;

public interface ListTodoRepository extends CrudRepository<ListTodoEntity, Long> {

}
