package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TaskTodoEntity;
import co.com.sofka.crud.repositories.TaskTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTodoService {

    @Autowired
    private TaskTodoRepository repositoryYTask;

    public Iterable<TaskTodoEntity> list(){
        return repositoryYTask.findAll();
    }

    public TaskTodoEntity save(TaskTodoEntity todo){
        return repositoryYTask.save(todo);
    }

    public void delete(Long id){
        repositoryYTask.delete(get(id));
    }

    public TaskTodoEntity get(Long id){
         return repositoryYTask.findById(id).orElseThrow();
    }

}
