package co.com.sofka.crud.controller;

import co.com.sofka.crud.DTO.TaskEntityDTO;
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

    @GetMapping(value = "/allTask")
    public Iterable<TaskEntityDTO> list(){
        return service.list();
    }
    
    @PostMapping(value = "/saveTask")
    public TaskEntityDTO save(@RequestBody TaskEntityDTO taskEntityDTO){
        return service.save(taskEntityDTO);
    }

    @PutMapping(value = "/saveTask")
    public TaskEntityDTO update(@RequestBody TaskEntityDTO taskEntityDTO) {
        if (taskEntityDTO.getId() != null) {
            return service.save(taskEntityDTO);
        }
        throw new RuntimeException("EL id seleccionado no existe");
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/idTask")
    public TaskEntityDTO get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
