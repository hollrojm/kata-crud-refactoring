import React, { useContext, useRef, useState } from "react";
import Store from "../../utils/Store";
import "bootstrap/dist/css/bootstrap.min.css";

const HOST_API = "http://localhost:8080/api";

const FormTaskCategory = (props) => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
    };
    fetch(HOST_API + "/saveCategory", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      id: item.id,
      name: state.name,
      todos: props.todos,
    };
  };

  return (
    <div className="container border border-success">
      <form ref={formRef}>
        {!item.id && (
          <button className="btn btn-outline-success mt-3" onClick={onAdd}>
            + Crear lista
          </button>
        )}
        <input
          className="form-control m-3 "
          type="text"
          required
          placeholder="TASKCATEGORIA"
          name="name"
          defaultValue={item.name}
          onChange={(event) => {
            setState({ ...state, name: event.target.value });
          }}
        ></input>
      </form>
    </div>
  );
};

export default FormTaskCategory;
