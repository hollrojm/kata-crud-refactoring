package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TaskTodoEntity;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TaskTodoEntity> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public TaskTodoEntity save(@RequestBody TaskTodoEntity todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public TaskTodoEntity update(@RequestBody TaskTodoEntity todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TaskTodoEntity get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
