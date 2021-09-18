import  React, { useContext, useRef, useState } from 'react';
import  Store from '../../utils/Store'
import 'bootstrap/dist/css/bootstrap.min.css';

  const HOST_API = "http://localhost:8080/api";

  const Form = (props) => {
    console.log(props);
  const formRef = useRef(null);
  const { dispatch, state: { taskCategory } } = useContext(Store);
  const item = taskCategory.item;
  const [state, setState] = useState(item);

 
  const onAdd = (event) => {
    event.preventDefault();
    console.log("guarrrrrr");
    const request = {
  
      id: null,
      completed: false,
      name: state.name,
      groupId: props.id
    };


    fetch(HOST_API + "/saveTask", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((taskCategory) => {
        dispatch({ type: "add-itemtask", item: taskCategory });
        setState({ name: "" });
      });
  };

  const onEdit = (event) => {
    console.log("editaaaaaaaa");
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted
    };


    fetch(HOST_API + "/saveTask", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((taskCategory) => {
        dispatch({ type: "edit-itemtask", item: taskCategory });
        setState({ name: "" });
      });
  };

  return <div className="backform"><form ref={formRef}>
    <input
      required
      type="text"
      name="name"
      placeholder="¿Qué piensas hacer hoy?"
      defaultValue={item.name}
      onChange={(event) => {
        setState({ ...state, name: event.target.value });
      }}></input>
    {item.id && <button onClick={onEdit}>Actualizar</button>}
    {!item.id && <button onClick={onAdd}>Crear</button>}
  </form>
  </div>
};


export default Form;

