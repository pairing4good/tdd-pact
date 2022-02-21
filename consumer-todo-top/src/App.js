import './App.css';


import React, { useState, useEffect } from 'react';
import { findAll } from './ToDoRepository'
import { filter } from './ToDoFilter'

function App() {

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    setTodos(filter(findAll()));
  }, []);

  return (
    <div>
      <h1>todos</h1>
      <ul class="todo-list">
        {todos.map((todo, index) => <li data-testid={"test-description-" + index}>{todo.description}</li>)}
      </ul>
    </div>
  );
}

export default App;
