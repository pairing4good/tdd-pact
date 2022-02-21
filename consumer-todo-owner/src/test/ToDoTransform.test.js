import { transform } from '../ToDoTransform'

it('should group by owner', () => {
    const items = [
        {id: 5, owner: 'test owner b', description: 'test description e'}, 
        {id: 3, owner: 'test owner b', description: 'test description c'}, 
        {id: 1, owner: 'test owner a', description: 'test description a'}, 
        {id: 2, owner: 'test owner a', description: 'test description b'}, 
        {id: 4, owner: 'test owner c', description: 'test description d'}]

    const transformedItems = transform(items)

    console.log(transformedItems)

    expect(transformedItems.length).toBe(3);
    expect(transformedItems[0].owner).toBe('test owner b');
    expect(transformedItems[0].todos.length).toBe(2);
    expect(transformedItems[0].todos[0].description).toBe('test description e');
    expect(transformedItems[0].todos[1].description).toBe('test description c');

    expect(transformedItems[1].owner).toBe('test owner a');
    expect(transformedItems[1].todos.length).toBe(2);
    expect(transformedItems[1].todos[0].description).toBe('test description a');
    expect(transformedItems[1].todos[1].description).toBe('test description b');

    expect(transformedItems[2].owner).toBe('test owner c');
    expect(transformedItems[2].todos.length).toBe(1);
    expect(transformedItems[2].todos[0].description).toBe('test description d');
})