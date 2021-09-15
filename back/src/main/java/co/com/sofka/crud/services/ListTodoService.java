package co.com.sofka.crud.services;


import co.com.sofka.crud.entities.ListTodoEntity;
import co.com.sofka.crud.repositories.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ListTodoService {

    @Autowired
    private ListTodoRepository repositoryList;

    public Iterable<ListTodoEntity> list(){
        return repositoryList.findAll();
    }

    public ListTodoEntity save(ListTodoEntity listTodoEntity){
        return repositoryList.save(listTodoEntity);
    }

    public void delete(Long id){
        repositoryList.delete(get(id));
    }

    public ListTodoEntity get(Long id){
        return repositoryList.findById(id).orElseThrow();
    }

}
