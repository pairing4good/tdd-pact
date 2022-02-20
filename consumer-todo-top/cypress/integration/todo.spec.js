describe('List ToDos', () => {
  beforeEach(() => {
    cy.visit('/')
  })

  it('should list all todos', () => {
    cy.get('.todo-list li').should('have.length', 5)


    cy.get('.todo-list li').eq(0).should('have.text', 'Renew your drivers license')
    cy.get('.todo-list li').eq(1).should('have.text', 'Fix the gate')
    cy.get('.todo-list li').eq(2).should('have.text', 'File taxes')
    cy.get('.todo-list li').eq(3).should('have.text', 'Change the car oil')
    cy.get('.todo-list li').eq(4).should('have.text', 'Weed the garden')
  })

})
