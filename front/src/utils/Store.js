import React, {createContext} from 'react';


const initialState = {
  todo: { list: [], item: {} },
  taskCategory:{list:[], item:{}}

};
 const Store = createContext(initialState)

 

 export default Store;