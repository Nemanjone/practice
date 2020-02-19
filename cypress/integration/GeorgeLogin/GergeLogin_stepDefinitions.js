import { Then, When } from "cypress-cucumber-preprocessor/steps";

When('I try to login with {string}', (search)=>{
    cy.server();
    cy.route('**/api/channels/**').as('pageProbablyLoaded');
    cy.visit('https://george.csas.cz/?login_hint=' + search)
    cy.wait('@pageProbablyLoaded', { timeout: 15000});
})

Then('I am asked to enter my date of birth', ()=>{
    cy.get('.info-text').children().first().contains('Zadejte den a měsíc narození')
})

Then('I am asked to enter my client number and username', ()=>{
    cy.get('input').should('have.attr', 'placeholder', 'Klientské číslo / Uživatelské jméno')
})