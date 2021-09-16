package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.ListTodo;
import co.com.sofka.crud.repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class ListTodoService {

    @Autowired
    private ListTodoRepository repository;

    public Iterable<ListTodo> list(){
        return repository.findAll();
    }

    public ListTodo save(ListTodo todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public ListTodo get(Long id){
        return repository.findById(id).orElseThrow();
    }
}
