package co.com.sofka.crud.services;


import co.com.sofka.crud.entities.TaskTodoEntity;
import co.com.sofka.crud.repositories.TaskTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTodoService {

    @Autowired
    private TaskTodoRepository repositoryTask;

    public Iterable<TaskTodoEntity> list(){
        return repositoryTask.findAll();
    }

    public TaskTodoEntity save(TaskTodoEntity todo){
        return repositoryTask.save(todo);
    }

    public void delete(Long id){
        repositoryTask.delete(get(id));
    }

    public TaskTodoEntity get(Long id){
         return repositoryTask.findById(id).orElseThrow();
    }

}
