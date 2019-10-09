## Spring Data Transactions

- declarative transaction mgt, programatic transaction mgt, rollbacks
- data transactions.

## Overview

- Most widely used in spring
- supports to focus on data logic instead of integrity of the system

## Database Transactions - ACID

- Atomicity - series of action ; all or nothing approach; cannot partially complete
- Consistency -  commited once all action complete ; consistent state
- Isolation - all transactions is isolated from other transactions ; a transaction doesn't see other transactions data.
- Durability - cannot be undone by a system failure - because written to a storage
- Transaction boudaries and Concurrent transactions

## Transaction

- A series of action treated as a single unit of works
- fail as a group or complete in a group
- if one step fails then rollback should occurs; else it should be committed

## Manage transactions

- without transactions, data can end up in an inconsistent state and become corrupted
- Transaction example - Booking system : Paying for seat and reserving a seat

```java
try{
    conn = dataSource.getConnection();
    conn.setAutoCommit(false);
    ticket.buy();
    seat.reserve();
    conn.commit();
}
catch(SQLException e){
    conn.rollback();
}

```

## Transaction Types

- global transactions : multiple resources manage the transactions , typically managed by the application servers, messaging tools...
- local transactions : one resource manages the transaction; dont run in an environment

## Spring framework

- transactions managed seamlessly
- consistent programming model accross global and local transactions
- benefits from different transaction management strategies
- programmatic transaction mgt - developer writes custom code to manage transactions and set boundaries
- declarative - separates transaction management from business code

## Isolation Levels

- Prevent problems when multiple programs executing concurrently :
- DEFAULT - Default from underlying database
- READ_UNCOMMITED - Read uncommited changes
- READ_COMMITED - Read only committed changes
- REPEATABLE_READ - Read identical values multiple times
- SERIALIZABLE - Read identical rows multiple times


## Manage Transactions

- Auto commit or rollback when fails
- Java Transaction API
- Java Persistence Api
- Hibernate
- JMS

- Consistent programming models accross several apis + programmatic and declarative transaction management
- undelying transactions managed by spring

```java

// Manual Transaction Management
public void saveTicket(Ticket ticket){
    Session session = sessionFactory.getCurrentSession();
    session.getTransaction().begin();
    session.save(ticket);
    session.getTransaction().commit();
}

// Using Spring
// Automatic rollback in case of errors
@Transactional
public void saveTicket(Ticket ticket){
    sessionFactory.getCurrentSession().save(ticket);
}
```

## Programmatic Transaction Management

- Transaction template - similar to other template like JDBCTemplate
- Platform transaction manager - manage transactions across hibernate , jdbc , jpa and jms
- Several transaction manager available in Spring - Platform Transactoin manager, JTA transaction manager,
- Hibernate Transaction Manager, Datasource Transaction Manager and JPA transaction manager.
- Hibernate Transaction Manager - Uniform API uses the features of Hibernate's transactions + Maintains the adv of Spring's unified transaction abstractions

## Declarative Transaction Management

- @Transactional Annotation -