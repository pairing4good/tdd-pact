import './App.css';


import React, { useState, useEffect } from 'react';
import { findAll } from './ToDoRepository'
import { filter } from './ToDoFilter'
import { transform } from './ToDoTransform'

function App() {

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    findAll(process.env.REACT_APP_TODO_API_BASE_URL).then( todos => setTodos(transform(filter(todos))));
  }, []);

  return (
    <div>
      <h1>todos</h1>
      <ul class="todo-list">
        {todos.map((todo, ownerIndex) => 
          <li data-testid={"test-owner-" + ownerIndex}><span class="todo-owner">{todo.owner}</span>
            <ul class={"todo-list-"+ownerIndex}>{todo.todos.map((ownedTodo, descIndex) => 
              <li data-testid={"test-description-" + ownerIndex + "-" + descIndex}>{ownedTodo.description}</li>)}
            </ul>
          </li>
        )}
      </ul>
    </div>
  );
}

export default App;
