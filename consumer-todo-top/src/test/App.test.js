import { render, screen } from '@testing-library/react';
import App from '../App';

jest.mock("../ToDoRepository", () => ({
  findAll: async () => new Promise((resolve) => resolve([
    {id:1, description: 'test 1', created: '2022-01-01T01:22:22.22+00:00'},
    {id:3, description: 'test 3', created: '2022-01-03T01:22:22.22+00:00'},
    {id:2, description: 'test 2', created: '2022-01-02T01:22:22.22+00:00'},
    {id:3, description: 'test 4', created: '2022-01-04T01:22:22.22+00:00'},
    {id:3, description: 'test 6', created: '2022-01-06T01:22:22.22+00:00'},
    {id:3, description: 'test 5', created: '2022-01-05T01:22:22.22+00:00'},
    {id:3, description: 'test 7', created: '2022-01-07T01:22:22.22+00:00'}
  ]))
}));

test('renders learn react link', async () => {
  render(<App />);
  const heading = screen.getByRole('heading', {level: 1});
  expect(heading).toBeInTheDocument();
  expect(heading).toHaveTextContent("todos");

  const firstNoteDescription = await screen.findByTestId('test-description-0');
  expect(firstNoteDescription).toHaveTextContent("test 7");

  const secondtNoteDescription = await screen.findByTestId('test-description-1');
  expect(secondtNoteDescription).toHaveTextContent("test 6");

  const thirdNoteDescription = await screen.findByTestId('test-description-2');
  expect(thirdNoteDescription).toHaveTextContent("test 5");

  const fourthNoteDescription = await screen.findByTestId('test-description-3');
  expect(fourthNoteDescription).toHaveTextContent("test 4");

  const fifthNoteDescription = await screen.findByTestId('test-description-4');
  expect(fifthNoteDescription).toHaveTextContent("test 3");
});