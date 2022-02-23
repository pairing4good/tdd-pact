import { Pact } from '@pact-foundation/pact';
import { Matchers } from '@pact-foundation/pact';
import { like } from '@pact-foundation/pact/src/dsl/matchers';
import { findAll } from '../ToDoRepository';
const { eachLike } = Matchers;


const provider = new Pact({
  consumer: 'ToDoWebDue',
  provider: 'ToDoAPI',
});

describe('ToDo Service', () => {
    describe('When a request to list all todos is made', () => {
      beforeAll(() =>
        provider.setup().then(() => {
          provider.addInteraction({
            uponReceiving: 'a request to list all todos',
            withRequest: {
              method: 'GET',
              path: '/todos',
            },
            willRespondWith: {
                body: eachLike({
                  id: like(1),
                  description: like('description 1'),
                  dueDate: like('2001-01-01T01:01:01.100+00:00')
                }),
                status: 200,
                headers: {
                  'Content-Type': 'application/json',
                },
              },
            })
          }))
  
      test('should return the correct data', async () => {
        const response = await findAll(provider.mockService.baseUrl);
        expect(response[0].id).toBe(1);
        expect(response[0].description).toBe('description 1');
        expect(response[0].dueDate).toBe('2001-01-01T01:01:01.100+00:00');
      });
  
      afterEach(() => provider.verify());
      afterAll(() => provider.finalize());
    });
  });