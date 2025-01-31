import React, { useContext, useEffect } from 'react';
import  Store from '../../utils/Store';
import  Form  from '../Task/Form';
import  Todo  from '../Task/Todo';
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const ListTask = () => {
  const { dispatch, state: { taskCategory } } = useContext(Store);
  const currentListTask = taskCategory.list;
 
  useEffect(() => {
    fetch(HOST_API + "/allCategories")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "all-itemtask", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/deleteCategory" +"/" + id,  {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-taskCategory", id });
    });
  };

 
   
  return <div className=" container text-center">
        {currentListTask.map((elemento) => {
            console.log(currentListTask);
            return <div  key={elemento.id} >
                <div >
                    <span  className="input-group-text text-primary"> <b> Nombre de la Categoria </b><input   className="form-control"  disabled={true} value={elemento.name} /></span>
                    
                    <button onClick={() => onDelete(elemento.id)} className="btn btn-outline-danger ">Eliminar Categoria</button>
                </div>
                <Form TodoListId={elemento.id} />
                <Todo TodoListId={elemento.id} />
            </div>
  })}
</div>

}

export default ListTask;