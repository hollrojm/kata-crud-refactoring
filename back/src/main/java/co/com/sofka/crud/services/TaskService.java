package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TaskEntity;
import co.com.sofka.crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;


    public Iterable<TaskEntity> list(){
        return repository.findAll();
    }

    public TaskEntity save(TaskEntity todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }


    public TaskEntity get(Long id){
         return repository.findById(id).orElseThrow();
    }

    public TaskEntity update(TaskEntity todo) {
        if(repository.findById(todo.getId()).isEmpty()){
            throw new RuntimeException("EL id seleccionado no existe");
        }
        return repository.save(todo);

    }

}
