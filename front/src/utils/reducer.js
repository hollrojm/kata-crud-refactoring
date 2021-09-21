export function reducer(state, action) {
  switch (action.type) {
    case 'update-item':
      const todoUpItem = state.todo;
      const listUpdateEdit = todoUpItem.list.map((item) => {
        if (item.id === action.item.id) {
          return action.item;
        }
        return item;
      });
      todoUpItem.list = listUpdateEdit;
      todoUpItem.item = {};
      return { ...state, todo: todoUpItem };
    case 'delete-taskCategory':
      const taskListDelete = state.taskCategory;
      const listTaskUpdate = taskListDelete.list.filter((elemento) => {
        return elemento.id !== action.id;
      });
      taskListDelete.list = listTaskUpdate;
      return { ...state, taskCategory: taskListDelete };
    // case 'taskCategory':
    //   const taskCategory = state.taskCategory;
    //   taskCategory.list = action.list;
    //   return { ...state, taskCategory: taskCategory };
    case 'delete-item':
      const todoUpDelete = state.todo;
      const listUpdate = todoUpDelete.list.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDelete.list = listUpdate;
      return { ...state, todo: todoUpDelete };
    case 'update-list':
      const todoUpList = state.todo;
      todoUpList.list = action.list;
      return { ...state, todo: todoUpList };
    case 'edit-item':
      const todoUpEdit = state.todo;
      todoUpEdit.item = action.item;
      return { ...state, todo: todoUpEdit };
    case 'add-itemtask':
      const todoUpTask = state.taskCategory.list;
      todoUpTask.push(action.item);
      return { ...state, taskCategory: { list: todoUpTask, item: {} } };
    case 'add-item':
      const todoUp = state.todo.list;
      todoUp.push(action.item);
      return { ...state, todo: { list: todoUp, item: {} } };
    case 'all-itemtask':
        const taskCategory = state.taskCategory;
        taskCategory.list = action.list;
        return { ...state, taskCategory: taskCategory };
    case 'todolist-add':
          const todoListAdd = state.taskCategory.list;
          todoListAdd.push(action.item);
          return { ...state, taskCategory: {list:todoListAdd} };
    
    default:
      return state;
  }
}
