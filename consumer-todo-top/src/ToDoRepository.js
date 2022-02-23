export async function findAll(url){
  const response = await fetch(url + '/todos');
  const values = await response.json();
  return values;
}