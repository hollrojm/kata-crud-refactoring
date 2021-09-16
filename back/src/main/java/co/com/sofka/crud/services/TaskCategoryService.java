package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TaskCategoryEntity;
import co.com.sofka.crud.repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class TaskCategoryService {

    @Autowired
    private ListTodoRepository repository;

    public Iterable<TaskCategoryEntity> list(){
        return repository.findAll();
    }

    public TaskCategoryEntity save(TaskCategoryEntity todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public TaskCategoryEntity get(Long id){
        return repository.findById(id).orElseThrow();
    }

    public TaskCategoryEntity update(TaskCategoryEntity listTodo) {
        if(repository.findById(listTodo.getId()).isEmpty()){
            throw new RuntimeException("EL id seleccionado no existe");
        }
        return repository.save(listTodo);

    }
}
