function custom_sort(a, b) {
  return  new Date(b.created).getTime() - new Date(a.created).getTime();
}

export function filter(todos){
    todos.sort(custom_sort)
    return todos.slice(0,5)
};