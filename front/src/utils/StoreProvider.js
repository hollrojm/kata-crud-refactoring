import React, { useReducer } from 'react';
import { reducer } from './reducer';
import  Store  from '../../src/utils/Store';


 const initialState = {
   todo: { list: [], item: {} },
   taskCategory:{list:[], item:{}}
 };

 const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>;

};
export default StoreProvider;