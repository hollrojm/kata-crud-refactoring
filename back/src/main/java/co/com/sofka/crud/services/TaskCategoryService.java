package co.com.sofka.crud.services;

import co.com.sofka.crud.DTO.TaskCategoryEntityDTO;
import co.com.sofka.crud.entities.TaskCategoryEntity;
import co.com.sofka.crud.mapper.TaskCategoryMapper;
import co.com.sofka.crud.repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public final class TaskCategoryService {

    @Autowired
    private ListTodoRepository repository;

    @Autowired
    private TaskCategoryMapper mapper;

    public Iterable<TaskCategoryEntityDTO> list(){
        List<TaskCategoryEntity> taskCats = (List<TaskCategoryEntity>) repository.findAll();
        return mapper.toTasksCategoryDto(taskCats);

    }

    public TaskCategoryEntityDTO save(TaskCategoryEntityDTO taskCategoryEntityDTO){
        TaskCategoryEntity taskCategoryEntity = mapper.toTaskCategoryEntity(taskCategoryEntityDTO);
        return mapper.toTaskCategoryDto(repository.save(taskCategoryEntity));

    }

    public void delete(Long id){
        TaskCategoryEntity taskCategoryEntity = mapper.toTaskCategoryEntity(get(id));
        repository.delete(taskCategoryEntity);
    }

    public TaskCategoryEntityDTO get(Long id){


        return repository.findById(id)
                .map(taskCategoryEntity -> mapper.toTaskCategoryDto(taskCategoryEntity))
                .orElseThrow();
    }


}
