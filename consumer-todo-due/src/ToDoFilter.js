function custom_sort(a, b) {
  return new Date(a.dueDate).getTime() - new Date(b.dueDate).getTime();
}

export function filter(todos) {
  return todos.sort(custom_sort);
};