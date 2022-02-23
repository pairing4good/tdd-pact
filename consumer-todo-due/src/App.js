import './App.css';

import React, { useState, useEffect } from 'react';
import { findAll } from './ToDoRepository'
import { filter } from './ToDoFilter'

function App() {

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    findAll(process.env.REACT_APP_TODO_API_BASE_URL).then( todos => setTodos(filter(todos)));
  }, []);

  return (
    <div>
      <h1>todos</h1>
      <ul className="todo-list">
        {todos.map((todo, index) => <li key={`todo-list-item-${index}`} data-testid={"test-description-" + index}>{new Date(todo.dueDate).toLocaleDateString()} {todo.description}</li>)}
      </ul>
    </div>
  );
}

export default App;
