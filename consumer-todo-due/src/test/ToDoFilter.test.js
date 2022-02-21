import { filter } from '../ToDoFilter'

it('should sort by id', () => {
    const items = [
        {id: 5, dueDate: '2022-01-05T01:01:01.01+00:00'}, 
        {id: 3, dueDate: '2022-01-03T01:01:01.01+00:00'}, 
        {id: 1, dueDate: '2022-01-01T01:01:01.01+00:00'}, 
        {id: 4, dueDate: '2022-01-04T01:01:01.01+00:00'}, 
        {id: 2, dueDate: '2022-01-02T01:01:01.01+00:00'}]

    const sortedItems = filter(items)

    expect(sortedItems.length).toBe(5);
    expect(sortedItems[0].id).toBe(1);
    expect(sortedItems[1].id).toBe(2);
    expect(sortedItems[2].id).toBe(3);
    expect(sortedItems[3].id).toBe(4);
    expect(sortedItems[4].id).toBe(5);
})