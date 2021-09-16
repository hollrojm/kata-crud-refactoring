package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.TaskCategoryEntity;
import co.com.sofka.crud.services.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public final class TaskCategoryController {

    @Autowired
    private TaskCategoryService service;

    @GetMapping(value = "/listtodoall")
    public Iterable<TaskCategoryEntity> list(){
        return service.list();
    }

    @PostMapping(value = "/listsavetodo")
    public TaskCategoryEntity save(@RequestBody TaskCategoryEntity listTodo){
        return service.save(listTodo);
    }

    @PutMapping(value = "/listtodoupdate")
    public TaskCategoryEntity update(@RequestBody TaskCategoryEntity listTodo){
            return service.update(listTodo);
    }
    @DeleteMapping(value = "/listtododelete/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/listtodoid/{id}")
    public TaskCategoryEntity get(@PathVariable("id") Long id){
        return service.get(id);
    }
}
