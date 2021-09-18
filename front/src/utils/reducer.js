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
    case 'delete-item':
      const todoUpDelete = state.taskCategory;
      const listUpdate = todoUpDelete.list.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDelete.list = listUpdate;
      return { ...state, todo: todoUpDelete };
    case 'delete-itemtask':
      const todoUpDeleteTask = state.todo;
      const listUpdateTask = todoUpDeleteTask.list.filter((item) => {
        return item.id !== action.id;
      });
      todoUpDeleteTask.list = listUpdateTask;
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
      //const todoUpEditTask = state.taskCategory;
      //todoUpEditTask.item = action.item;
      //return { ...state, todo: todoUpEditTask };
      const todoUpTask = state.taskCategory.list;
      todoUpTask.push(action.item);
      return { ...state, taskCategory: { list: todoUpTask, item: {} } };
    case 'add-item':
      
      const todoUp = state.todo.list;
      todoUp.push(action.item);
      return { ...state, todo: { list: todoUp, item: {} } };
    default:
      return state;
  }
}
