function custom_sort(a, b) {
  return  new Date(a.id).getTime() - new Date(b.id).getTime();
}

export function filter(todos){
    return todos.sort(custom_sort)
};