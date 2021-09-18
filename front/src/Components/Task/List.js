import React, { useContext, useEffect } from 'react';
import  Store  from '../../utils/Store';
import  Form  from '../Task/Form';
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const List = (props) => {
  const { dispatch, state: { taskCategory } } = useContext(Store);
  const currentList = taskCategory.list;
  const currentListTask = currentList.filter(task => task.groupListId == props.id)

  useEffect(() => {
    fetch( HOST_API + "/allTask",)
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API +"/"+ id,{
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo });
  };

  const onChange = (event, todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      completed: event.target.checked
    };
    fetch(HOST_API + "/deleteCategory", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
      });
  };

  const decorationDone = {
    textDecoration: 'line-through'
  };
  return <div className="container">
    
        {currentList.map((todo) => {
          return (
          <div className="container">{todo.id}
          {todo.name}
          <button onClick={() => onDelete(todo.id)}>Eliminar</button>
          <Form idCategoria = {todo.id}
            /> 
          </div>
          
          )
        })}
  </div>
};
export default List;