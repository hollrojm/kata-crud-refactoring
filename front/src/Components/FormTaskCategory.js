import React, { useContext, useRef, useState } from 'react';
import { Store, HOST_API } from '../App';
import 'bootstrap/dist/css/bootstrap.min.css';

  const FormTaskCategory = () => {
  const formRef = useRef(null);
  const { dispatch, state: { todo } } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      completed: false
    };


    fetch(HOST_API + "/saveCategory", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted
    };
  };

  return <form ref={formRef}>
    <input className="form-control"
      type="text"
      required
      placeholder= "TASKCATEGORIA"
      name="name"
      defaultValue={item.name}
      onChange={(event) => {
        setState({ ...state, name: event.target.value });
      }}></input>
    {!item.id && <button className="btn btn-outline-success" onClick={onAdd}>Crear</button>}
  </form>;
};

export default FormTaskCategory; 
