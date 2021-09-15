package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TaskTodoEntity;
import co.com.sofka.crud.services.TaskTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public final class TaskTodoController {

    @Autowired
    private TaskTodoService Servicetask;

    @GetMapping(value = "/alltasks")
    public Iterable<TaskTodoEntity> list(){
        return Servicetask.list();
    }

    @PostMapping(value = "/savetask")
    public TaskTodoEntity save(@RequestBody TaskTodoEntity todo){
        return Servicetask.save(todo);
    }

    @PutMapping(value = "/updatetask")
    public TaskTodoEntity update(@RequestBody TaskTodoEntity todo){
        if(todo.getId() != null){
            return Servicetask.save(todo);
        }
        throw new RuntimeException("No existe id para actualizar");
    }

    @DeleteMapping(value = "/deletetask{id}")
    public void delete(@PathVariable("id")Long id){
        Servicetask.delete(id);
    }

    @GetMapping(value = "/taskid{id}")
    public TaskTodoEntity get(@PathVariable("id") Long id){
        return Servicetask.get(id);
    }
}
