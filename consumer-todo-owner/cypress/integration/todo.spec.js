describe('List ToDos', () => {
  beforeEach(() => {
    cy.visit('/')
  })

  it('should list all todos', () => {
    cy.get('.todo-list li span.todo-owner').should('have.length', 5)

    cy.get('.todo-list li span.todo-owner').eq(0).should('have.text', 'bsmith')
    cy.get('.todo-list-0 li').should('have.length', 3)
    cy.get('.todo-list-0 li').eq(0).should('have.text', 'Take out the garbage')
    cy.get('.todo-list-0 li').eq(1).should('have.text', 'Feed the dog')
    cy.get('.todo-list-0 li').eq(2).should('have.text', 'File taxes')

    cy.get('.todo-list li span.todo-owner').eq(1).should('have.text', 'hjones')
    cy.get('.todo-list-1 li').should('have.length', 2)
    cy.get('.todo-list-1 li').eq(0).should('have.text', 'Wash the dishes')
    cy.get('.todo-list-1 li').eq(1).should('have.text', 'Winterize the house')

    cy.get('.todo-list li span.todo-owner').eq(2).should('have.text', 'jbrown')
    cy.get('.todo-list-2 li').should('have.length', 2)
    cy.get('.todo-list-2 li').eq(0).should('have.text', 'Change the car oil')
    cy.get('.todo-list-2 li').eq(1).should('have.text', 'Fix the gate')

    cy.get('.todo-list li span.todo-owner').eq(3).should('have.text', 'mwhite')
    cy.get('.todo-list-3 li').should('have.length', 2)
    cy.get('.todo-list-3 li').eq(0).should('have.text', 'Weed the garden')
    cy.get('.todo-list-3 li').eq(1).should('have.text', 'Renew your drivers license')

    cy.get('.todo-list li span.todo-owner').eq(4).should('have.text', 'zloda')
    cy.get('.todo-list-4 li').should('have.length', 1)
    cy.get('.todo-list-4 li').eq(0).should('have.text', 'Fold the laundry')
  })

})
