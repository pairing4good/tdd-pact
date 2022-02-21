function custom_sort(a, b) {
  return  a.id - b.id;
}

export function filter(todos){
    return todos.sort(custom_sort)
};