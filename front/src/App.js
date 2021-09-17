import React, { createContext } from 'react';
import { List } from './Components/List';
import { StoreProvider } from './utils/StoreProvider';
import FormTaskCategory from './Components/FormTaskCategory'

export const HOST_API = "http://localhost:8080/api";
export const initialState = {
  todo: { list: [], item: {} }
};
export const Store = createContext(initialState)


function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <FormTaskCategory />
    <List />
    
  </StoreProvider>
}

export default App;
