import { filter } from '../ToDoFilter'

it('should sort by id', () => {
    const items = [{id: 5}, {id: 3}, {id: 1}, {id: 4}, {id: 2}]

    const sortedItems = filter(items)

    expect(sortedItems.length).toBe(5);
    expect(sortedItems[0].id).toBe(1);
    expect(sortedItems[1].id).toBe(2);
    expect(sortedItems[2].id).toBe(3);
    expect(sortedItems[3].id).toBe(4);
    expect(sortedItems[4].id).toBe(5);
})