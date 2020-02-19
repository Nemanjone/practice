/// <reference types="cypress" />

context('Actions', () => {
  beforeEach(() => {
	  cy.server();
	cy.route('**/api/channels/**').as('getData');
	    cy.visit('https://george.csas.cz/?login_hint=7777777777')
	cy.wait('@getData');
  })


  it('login trial', () => {
	    cy.get('button#btn\\.continue').click()
	  cy.route('**/gapi/my/state').as('loggedIn')
	  cy.wait('@loggedIn', { timeout: 40000})
	  cy.get('#accountName').should('exist')
  })
})
