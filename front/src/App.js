import React, { createContext } from 'react';
import  ListTask  from './Components/Category/ListTask';
import  StoreProvider  from './utils/StoreProvider';
import FormTask from './Components/Category/FormTask'
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return <StoreProvider>
    <div>
    <h3 className="text-center">Agenda de tareas</h3>
    </div>
    <FormTask />
    <ListTask />
    
  </StoreProvider>
}

export default App;
