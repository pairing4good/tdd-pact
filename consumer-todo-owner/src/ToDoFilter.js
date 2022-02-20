function custom_sort(a, b) {
  if(a.owner < b.owner) { return -1; }
  if(a.owner > b.owner) { return 1; }
  return 0;
}

export function filter(todos){
    return todos.sort(custom_sort)
};