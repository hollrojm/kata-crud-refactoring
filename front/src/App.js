import React, { createContext } from 'react';
import  ListTaskCategory  from './Components/Category/ListTaskCategory';
import  StoreProvider  from './utils/StoreProvider';
import FormTaskCategory from './Components/Category/FormTaskCategory'
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return <StoreProvider>
    <div>
    <h3 className="text-center">Agenda de tareas</h3>
    </div>
    <FormTaskCategory />
    <ListTaskCategory />
    
  </StoreProvider>
}

export default App;
