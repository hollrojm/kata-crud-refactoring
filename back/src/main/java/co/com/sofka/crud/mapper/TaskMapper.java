package co.com.sofka.crud.mapper;

import co.com.sofka.crud.DTO.TaskEntityDTO;
import co.com.sofka.crud.entities.TaskEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskEntityDTO toTaskDto(TaskEntity taskEntity);
    List<TaskEntityDTO> toTasksDto(List<TaskEntity> taskEntities);


    @InheritInverseConfiguration
    TaskEntity toTaskEntity(TaskEntityDTO taskEntityDTO);


}
