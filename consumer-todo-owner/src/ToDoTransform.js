export function transform(todos){
  var result = [];
  var currentOwner = '';
  var currentOwnerObject = {};

  todos.forEach(function(todo) {
    if(currentOwner === todo.owner){
      currentOwnerObject.todos.push({'id': todo.id, 'description': todo.description})
    }else{
      currentOwnerObject = {'owner':todo.owner, 'todos': [{'id': todo.id, 'description': todo.description}]}
      result.push(currentOwnerObject)
      currentOwner = todo.owner
    }
  });
  console.log(result)
  return result
};