import { Pact } from '@pact-foundation/pact';
import { Matchers } from '@pact-foundation/pact';
import { findAll } from '../ToDoRepository';
const { eachLike } = Matchers;


const provider = new Pact({
  consumer: 'ToDoWeb',
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
                  id: 1,
                  description: 'description 1',
                }),
                status: 200,
                headers: {
                  'Content-Type': 'application/json; charset=utf-8',
                },
              },
            })
          }))
  
      test('should return the correct data', async () => {
        const response = await findAll(provider.mockService.baseUrl);
        expect(response[0].id).toBe(1);
        expect(response[0].description).toBe('description 1');
      });
  
      afterEach(() => provider.verify());
      afterAll(() => provider.finalize());
    });
  });