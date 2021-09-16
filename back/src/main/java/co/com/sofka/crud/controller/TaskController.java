package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TaskEntity;
import co.com.sofka.crud.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping(value = "/todos")
    public Iterable<TaskEntity> list(){
        return service.list();
    }
    
    @PostMapping(value = "/todosave")
    public TaskEntity save(@RequestBody TaskEntity todo){
        return service.save(todo);
    }

    @PutMapping(value = "/todoupdate")
    public TaskEntity update(@RequestBody TaskEntity todo) {
        return service.update(todo);
    }

    @DeleteMapping(value = "/tododelete/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/todoid")
    public TaskEntity get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
