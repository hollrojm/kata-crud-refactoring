package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TaskTodoEntity;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<TaskTodoEntity> list(){
        return repository.findAll();
    }

    public TaskTodoEntity save(TaskTodoEntity todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public TaskTodoEntity get(Long id){
         return repository.findById(id).orElseThrow();
    }

}
