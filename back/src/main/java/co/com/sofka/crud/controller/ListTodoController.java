package co.com.sofka.crud.controller;

import co.com.sofka.crud.entities.ListTodoEntity;
import co.com.sofka.crud.services.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class ListTodoController {

    @Autowired
    private ListTodoService serviceList;

    @GetMapping(value = "/listsall")
    public Iterable<ListTodoEntity> list(){
        return serviceList.list();
    }
    
    @PostMapping(value = "/savelist")
    public ListTodoEntity save(@RequestBody ListTodoEntity listTodoEntity){
        return serviceList.save(listTodoEntity);
    }

    @PutMapping(value = "/updatelist")
    public ListTodoEntity update(@RequestBody ListTodoEntity listTodoEntity){
        if(listTodoEntity.getId() != null){
            return serviceList.save(listTodoEntity);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "/deletelist/{id}")
    public void delete(@PathVariable("id")Long id){
        serviceList.delete(id);
    }

    @GetMapping(value = "/listid/{id}")
    public ListTodoEntity get(@PathVariable("id") Long id){
        return serviceList.get(id);
    }

}
