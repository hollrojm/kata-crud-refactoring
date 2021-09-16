package co.com.sofka.crud.services;

import co.com.sofka.crud.DTO.TaskEntityDTO;
import co.com.sofka.crud.entities.TaskEntity;
import co.com.sofka.crud.mapper.TaskMapper;
import co.com.sofka.crud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskMapper mapper;


    public Iterable<TaskEntityDTO> list(){
        List<TaskEntity> tasks = (List<TaskEntity>) repository.findAll();
        return mapper.toTasksDto(tasks);

    }

    public TaskEntityDTO save(TaskEntityDTO taskEntityDTO){
        TaskEntity taskEntity = mapper.toTaskEntity(taskEntityDTO);
        return mapper.toTaskDto(repository.save(taskEntity));

    }

    public void delete(Long id){
        TaskEntity taskEntity = mapper.toTaskEntity(get(id));
        repository.delete(taskEntity);
    }


    public TaskEntityDTO get(Long id){

        return repository.findById(id)
                .map(taskEntity -> mapper.toTaskDto(taskEntity))
                .orElseThrow();
    }

}
