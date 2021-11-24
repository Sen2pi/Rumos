# Rumos

This a Degree Project that will be done in 3 parts , first is core JAVA , Second is using JAVA FX , THIRD STILL don't know.

In the JAVA FX IS just transforming this in a JAVA interface.

This a Digital Bank Management system with some features:
2 diferent Login Pages:
--1 - ATM
--2 - Digital Bank Management System

The ATM is needed to login :
---------->CARD NUMBER AND A PIN CODE
the DBMS :
---------> NIF AND PASSWORD

i made a presetDAta to be easier to star use and test.

The ATM part implements the followinf feature:
    Deposit
    Withdraw
    transfert ( to another account nib)
    Create a new credit Card
    Create a new Debit Card
    History of operations ( Movements)

The DBMS:
    See all clients, Accounts and Cards
    Create a new Client ( Account(AUTO) and card (OPTIONAL)) 
    Create a secondary client ( this one will be a secondary owner of an account.
    Create a new Credit Card
    Create a new Debot Card
    Update client Data (every single parameter) 
    Update Account, 
    Update Cards,

This projects is done by following an architecture OF (MODEL  ; REPOSITORY ; SERVICE)
MODEL :
  HANDLES ALL TEMPLATES
REPOSITORY:
  HANDLES ALL DB'S AND THEIR FOLLOWING IMPLEMENTATIONS
SERVICE:
  IMPLEMENTS AND MAKE THE MAGIC HAPPENS FROM THE PREVIOUS ONES :)

AS SUCH ARCHITECTURE THE MAIN CLASS AS ONLY THE RUN CONSTRUCTOR; WICH ON THIS CASE IS A SELECTOR BETWEEN 2 CONSOLES.
