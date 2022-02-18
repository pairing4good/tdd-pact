describe('List ToDos', () => {
  beforeEach(() => {
    // Cypress starts out with a blank slate for each test
    // so we must tell it to visit our website with the `cy.visit()` command.
    // Since we want to visit the same URL at the start of all our tests,
    // we include it in our beforeEach function so that it runs before each test
    cy.visit('/')
  })

  it('should list all todos', () => {
    cy.get('.todo-list li').should('have.length', 10)

    cy.get('.todo-list li').eq(0).should('have.text', '2/19/2022 Feed the dog')
    cy.get('.todo-list li').eq(1).should('have.text', '2/19/2022 Renew your drivers license')
    cy.get('.todo-list li').eq(2).should('have.text', '2/20/2022 Fold the laundry')
    cy.get('.todo-list li').eq(3).should('have.text', '2/20/2022 Fix the gate')
    cy.get('.todo-list li').eq(4).should('have.text', '2/21/2022 File taxes')
    cy.get('.todo-list li').eq(5).should('have.text', '2/23/2022 Take out the garbage')
    cy.get('.todo-list li').eq(6).should('have.text', '2/25/2022 Change the car oil')
    cy.get('.todo-list li').eq(7).should('have.text', '2/28/2022 Wash the dishes')
    cy.get('.todo-list li').eq(8).should('have.text', '3/15/2022 Winterize the house')
    cy.get('.todo-list li').eq(9).should('have.text', '5/29/2022 Weed the garden')
  })

})
