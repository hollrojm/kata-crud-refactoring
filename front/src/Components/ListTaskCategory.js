import React, { useContext, useEffect } from 'react';
import { Store, HOST_API } from '../App';
import  Form  from './Form';
import 'bootstrap/dist/css/bootstrap.min.css';

export const List = () => {
  const { dispatch, state: { todo } } = useContext(Store);
  const currentList = todo.list;

  useEffect(() => {
    fetch(HOST_API + "/allCategories")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/deleteCategory" +"/" + id +  {
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
  return <div>
    
        {currentList.map((todo) => {
          return  (
          <div>{todo.id}
          {todo.name}
          <input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input>
          <button onClick={() => onDelete(todo.id)}>Eliminar</button>
          <button onClick={() => onEdit(todo)}>Editar</button>
          <Form /> 
          </div>)
          
           
        })}
      
    
    
  </div>;
};
