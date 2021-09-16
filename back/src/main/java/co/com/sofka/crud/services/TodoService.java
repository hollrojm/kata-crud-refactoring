package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;


    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }


    public Todo get(Long id){
         return repository.findById(id).orElseThrow();
    }

    public Todo update(Todo todo) {
        if(repository.findById(todo.getId()).isEmpty()){
            throw new RuntimeException("EL id seleccionado no existe");
        }
        return repository.save(todo);

    }

}
