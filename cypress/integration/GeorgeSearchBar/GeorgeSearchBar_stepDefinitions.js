import { Given, Then, When, And } from "cypress-cucumber-preprocessor/steps";

const url = 'https://george.csas.cz/?login_hint=7777777777' 
const yourProducts = '#main\\.menu\\.v2\\.productsLink'
const portfolioJiri = '[data-cy="nav-category-SECURITIES"]'
const searchBar = '#transactions-searchtb'
const formContainer  = '#newtransfer-to-container' 
const titleSum = '.securityTitleSumRow'
const titlesList = "#titlesList"

Given('Visit George CZ demo page', () => {
	cy.server();
        cy.route('**/api/channels/**').as('pageProbablyLoaded');
        cy.visit(url)
        cy.wait('@pageProbablyLoaded', { timeout: 25000});

	 cy.get('button#btn\\.continue').click()
         cy.route('**/gapi/my/state').as('loggedIn')
         cy.wait('@loggedIn', { timeout: 60000})
         cy.get('#accountName').should('exist')
})

And('Navigate to Your Products', () => {
        cy.get(yourProducts).click({force: true})
})

And('Go to  Portfolios JIŘÍ SPOKOJENÝ', () => {
    cy.get(portfolioJiri).parent().find('h4').contains("Jiří Spokojený").click({force: true})
})
 
When('Search for {string} in Search Bar', (search)=>{
        cy.server();
        cy.route('**/my/securities/**').as('securitiesLoaded');
        cy.wait('@securitiesLoaded', { timeout: 25000});

     cy.get(searchBar).type(search)
	cy.get(formContainer).parent().submit()
 })
 
Then('Check the results of the search', ()=>{
    cy.get(titleSum).contains('4')
    cy.get(titlesList).children().should('have.length', 4)
    cy.get(titlesList).contains('Erste')
})

Then('Check the search bar status for empty string', ()=>{
    cy.get(titleSum).contains('9')
    cy.get(titlesList).children().should('have.length', 9)
    cy.get(titlesList).contains('DEUTSCHE BANK AG OPEN-END')
    cy.get(titlesList).contains('ČS nemovitostní fond')
    cy.get(titlesList).contains('JB PHYSICAL GOLD FND-A-EUR - ETF')
    cy.get(titlesList).contains('Měnový prémiový')
    cy.get(titlesList).contains('Prémiový dluhopis MULTI 6')
})

Then('Check the search status for invalid characters', ()=>{
    cy.get('.text-center').contains('V současné době nemáte žádné investice.') 
})

Then('Check the search status for Lorem ipsum', ()=>{
    cy.get('.text-center').contains('V současné době nemáte žádné investice.')  
})