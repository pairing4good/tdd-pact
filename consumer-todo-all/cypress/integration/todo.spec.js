describe('List ToDos', () => {
  beforeEach(() => {
    cy.visit('/')
  })

  it('should list all todos', () => {
    cy.get('.todo-list li').should('have.length', 10)

    cy.get('.todo-list li').eq(0).should('have.text', 'Take out the garbage')
    cy.get('.todo-list li').eq(1).should('have.text', 'Wash the dishes')
    cy.get('.todo-list li').eq(2).should('have.text', 'Fold the laundry')
    cy.get('.todo-list li').eq(3).should('have.text', 'Feed the dog')
    cy.get('.todo-list li').eq(4).should('have.text', 'Winterize the house')
    cy.get('.todo-list li').eq(5).should('have.text', 'Weed the garden')
    cy.get('.todo-list li').eq(6).should('have.text', 'Change the car oil')
    cy.get('.todo-list li').eq(7).should('have.text', 'File taxes')
    cy.get('.todo-list li').eq(8).should('have.text', 'Fix the gate')
    cy.get('.todo-list li').eq(9).should('have.text', 'Renew your drivers license')
  })

})
