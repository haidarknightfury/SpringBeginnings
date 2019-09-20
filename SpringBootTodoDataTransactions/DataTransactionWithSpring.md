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


	10256