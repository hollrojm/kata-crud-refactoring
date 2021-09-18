import React, { useContext, useEffect } from 'react';
import  Store from '../../utils/Store';
import  Form  from '../Task/Form';
import  List  from '../Task/List';
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const ListTask = () => {
  const { dispatch, state: { taskCategory } } = useContext(Store);
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
  {currentListTask.map((elemento) => {
      return <div key={elemento.id} className="row border rounded" >
          <div >
              <span  className="input-group-text text-primary"> <b> Nombre de la TodoList </b></span>
              <input   className="form-control"  disabled={true} value={elemento.nameList} />
              <button onClick={() => onDelete(elemento.id)} className="btn btn-outline-danger ">Eliminar</button>
          </div>
          <Form TodoListId={elemento.id} />
          <List TodoListId={elemento.id} />
      </div>
  })}
</div>

}

export default ListTask;