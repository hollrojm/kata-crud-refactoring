package co.com.sofka.crud.mapper;

import co.com.sofka.crud.DTO.TaskCategoryEntityDTO;
import co.com.sofka.crud.entities.TaskCategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskCategoryMapper {

    TaskCategoryEntityDTO toTaskCategoryDto(TaskCategoryEntity taskCategoryEntity);
    List<TaskCategoryEntityDTO> toTasksCategoryDto(List<TaskCategoryEntity> taskCategoryEntities );

    @InheritInverseConfiguration
    TaskCategoryEntity toTaskCategoryEntity(TaskCategoryEntityDTO taskCategoryEntityDTO);
}
