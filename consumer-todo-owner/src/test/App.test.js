import { render, screen } from '@testing-library/react';
import App from '../App';

jest.mock("../ToDoRepository", () => ({
  findAll: async () => new Promise((resolve) => resolve([
    {id:1, owner: 'owner 1', description: 'test 1'},
    {id:3, owner: 'owner 2', description: 'test 3'},
    {id:2, owner: 'owner 1', description: 'test 2'}
  ]))
}));

test('renders learn react link', async () => {
  render(<App />);
  const heading = screen.getByRole('heading', {level: 1});
  expect(heading).toBeInTheDocument();
  expect(heading).toHaveTextContent("todos");

  const firstOwner = await screen.findByTestId('test-owner-0');
  expect(firstOwner).toHaveTextContent("test 1");

  const firstDescription = await screen.findByTestId('test-description-0-0');
  expect(firstDescription).toHaveTextContent("test 1");

  const secondtDescription = await screen.findByTestId('test-description-0-1');
  expect(secondtDescription).toHaveTextContent("test 2");

  const secondOwner = await screen.findByTestId('test-owner-1');
  expect(secondOwner).toHaveTextContent("test 3");

  const thirdDescription = await screen.findByTestId('test-description-1-0');
  expect(thirdDescription).toHaveTextContent("test 3");
});