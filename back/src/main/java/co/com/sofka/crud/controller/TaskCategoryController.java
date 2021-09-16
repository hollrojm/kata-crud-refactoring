package co.com.sofka.crud.controller;

import co.com.sofka.crud.DTO.TaskCategoryEntityDTO;
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

    @GetMapping(value = "/allCategories")
    public Iterable<TaskCategoryEntityDTO> list(){
        return service.list();
    }

    @PostMapping(value = "/saveCategory")
    public TaskCategoryEntityDTO save(@RequestBody TaskCategoryEntityDTO taskCategoryEntityDTO){
        return service.save(taskCategoryEntityDTO);

    }
    @PutMapping(value = "/saveCategory")
    public TaskCategoryEntityDTO update(@RequestBody TaskCategoryEntityDTO taskCategoryEntityDTO) {
        if(taskCategoryEntityDTO.getId() != null){
            return service.save(taskCategoryEntityDTO);
        }

        throw new RuntimeException("EL id seleccionado no existe");
    }

    @DeleteMapping(value = "/deleteCategory/{id}")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "/categoryByid/{id}")
    public TaskCategoryEntityDTO get(@PathVariable("id") Long id){
        return service.get(id);
    }
}
