import React, { useContext, useEffect } from 'react';
import  Store from '../../utils/Store';
import  Form  from '../Task/Form';
import  List  from '../Task/List';
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const ListTaskCategory = () => {
  const { dispatch, state: { todo } } = useContext(Store);
  const currentList = todo.list;

  useEffect(() => {
    fetch(HOST_API + "/allCategories")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);


  const onDelete = (catid) => {
    fetch(HOST_API + "/deleteCategory" +"/" + catid,  {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-item", catid });
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
    fetch(HOST_API + "/saveCategory", {
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
            
          <div>
            <p>Categorias---</p>
            {todo.id}
          {todo.name}
          <input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input>
          <button onClick={() => onDelete(todo.id)}>Eliminar</button>
          <Form id={todo.id}/> 
          <List idlist={todo.id}/> 


          <p>Fin Categorias---</p>
          </div>)
          
           
        })}
      
    
    
  </div>;
};
export  default ListTaskCategory