package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/todos")
    public Iterable<Todo> list(){
        return service.list();
    }
    
    @PostMapping(value = "/todosave")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value = "/todoupdate")
    public Todo update(@RequestBody Todo todo) {
        return service.update(todo);
    }

    @DeleteMapping(value = "/tododelete/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/todoid")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
