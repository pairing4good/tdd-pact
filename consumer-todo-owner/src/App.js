import './App.css';


import React, { useState, useEffect } from 'react';
import { findAll } from './ToDoRepository'
import { filter } from './ToDoFilter'
import { transform } from './ToDoTransform'

function App() {

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    setTodos(transform(filter(findAll())));
  }, []);

  return (
    <div>
      <h1>todos</h1>
      <ul class="todo-list">
        {todos.map((todo, index) => 
          <li><span class="todo-owner">{todo.owner}</span>
            <ul class={"todo-list-"+index}>{todo.todos.map((ownedTodo) => 
              <li>{ownedTodo.description}</li>)}
            </ul>
          </li>
        )}
      </ul>
    </div>
  );
}

export default App;
