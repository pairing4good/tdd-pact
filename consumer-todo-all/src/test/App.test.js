import { render, screen } from '@testing-library/react';
import App from '../App';

jest.mock("../ToDoRepository", () => ({
  findAll: async () => new Promise((resolve) => resolve([
    {id:1, description: 'test 1'},
    {id:3, description: 'test 3'},
    {id:2, description: 'test 2'}
  ]))
}));

test('renders learn react link', async () => {
  render(<App />);
  const heading = screen.getByRole('heading', {level: 1});
  expect(heading).toBeInTheDocument();
  expect(heading).toHaveTextContent("todos");

  const firstNoteDescription = await screen.findByTestId('test-description-0');
  expect(firstNoteDescription).toHaveTextContent("test 1");

  const secondtNoteDescription = await screen.findByTestId('test-description-1');
  expect(secondtNoteDescription).toHaveTextContent("test 2");

  const thirdNoteDescription = await screen.findByTestId('test-description-2');
  expect(thirdNoteDescription).toHaveTextContent("test 3");
});