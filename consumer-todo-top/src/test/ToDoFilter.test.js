import { filter } from '../ToDoFilter'

it('should sort by id', () => {
    const items = [
        {id:1, created: '2022-01-01T01:22:22.22+00:00'},
        {id:3, created: '2022-01-03T01:22:22.22+00:00'},
        {id:2, created: '2022-01-02T01:22:22.22+00:00'},
        {id:4, created: '2022-01-04T01:22:22.22+00:00'},
        {id:6, created: '2022-01-06T01:22:22.22+00:00'},
        {id:5, created: '2022-01-05T01:22:22.22+00:00'},
        {id:7, created: '2022-01-07T01:22:22.22+00:00'}]

    const sortedItems = filter(items)

    expect(sortedItems.length).toBe(5);
    expect(sortedItems[0].id).toBe(7);
    expect(sortedItems[1].id).toBe(6);
    expect(sortedItems[2].id).toBe(5);
    expect(sortedItems[3].id).toBe(4);
    expect(sortedItems[4].id).toBe(3);
})