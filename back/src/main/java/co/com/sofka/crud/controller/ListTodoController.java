package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.ListTodo;
import co.com.sofka.crud.entities.Todo;
import co.com.sofka.crud.services.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public final class ListTodoController {

    @Autowired
    private ListTodoService service;

    @GetMapping(value = "/listtodoall")
    public Iterable<ListTodo> list(){
        return service.list();
    }

    @PostMapping(value = "/listsavetodo")
    public ListTodo save(@RequestBody ListTodo listTodo){
        return service.save(listTodo);
    }

    @PutMapping(value = "/listtodoupdate")
    public ListTodo update(@RequestBody ListTodo listTodo){
        if(listTodo.getId() != null){
            return service.save(listTodo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/listtododelete")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/listtodoid/{id}")
    public ListTodo get(@PathVariable("id") Long id){
        return service.get(id);
    }
}
