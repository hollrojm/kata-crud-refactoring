import React, { useContext, useEffect } from 'react';
import  Store from '../../utils/Store';
import  Form  from '../Task/Form';
import  Todo  from '../Task/Todo';
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const ListTask = () => {
  const { dispatch, state: { taskCategory, element } } = useContext(Store);
  const currentListTask = taskCategory.list;

  useEffect(() => {
    fetch(HOST_API + "/allCategories")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "add-itemtask", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/deleteCategory" +"/" + id,  {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-itemtask", id });
    });
  };

  // const onEdit = (todo) => {
  //   dispatch({ type: "edit-item", item: todo });
  // };

  // 
  return <div className=" container text-center">
        {currentListTask.map((item) => {
            return <div  key={item} >
                <div >
                    <span  className="input-group-text text-primary"> <b> Nombre de la Categoria </b></span>
                    <input   className="form-control"  disabled={true} value={item} />
                    <button onClick={() => onDelete(item)} className="btn btn-outline-danger ">Eliminar</button>
                </div>
                <Form TodoListId={item} />
                <Todo TodoListId={item} />
            </div>
  })}
</div>

}

export default ListTask;