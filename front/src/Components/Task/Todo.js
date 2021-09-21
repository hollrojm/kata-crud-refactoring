import React, { useContext, useEffect } from 'react';
import  Store  from '../../utils/Store';
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const Todo = (props) => {
  const { dispatch, state: { todo } } = useContext(Store);
  const currentList = todo.list.filter(todo => {
    return todo.groupId === props.TodoListId; //Cabiar esta variable 
  });

  useEffect(() => {
    fetch( HOST_API + "/allTask",)
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/deleteTask/" + id,{
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
      completed: event.target.checked,
      groupId: props.TodoListId //cambiar esta variable
    };
    fetch(HOST_API + "/saveTask", {
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
  <table  className="table table-striped">
    <thead >
      <tr class="table table-striped table-succes">
        <td >ID</td>
        <td >Tarea</td>
        <td >Completado</td>
        <td >Eliminar Tarea</td>
        <td >Editar Tarea</td>
      </tr>
    </thead>
    <tbody>
      {currentList.map((todo) => {
        return <tr class="table-primary" key={todo.id} style={todo.completed ? decorationDone : {}}>
          <td >{todo.id}</td>
          <td>{todo.name}</td>
          <td><input type="checkbox" defaultChecked={todo.completed} onChange={(event) => onChange(event, todo)}></input></td>
          <td><button  className="btn btn-danger"onClick={() => onDelete(todo.id)} >Eliminar</button></td>
          <td><button  className="btn btn-success" onClick={() => onEdit(todo)} >Editar</button></td>
        </tr>
      })}
    </tbody>
  </table>
</div>
}

export default Todo;