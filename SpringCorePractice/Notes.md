Sprint Framework in Depth - Intro

1. Spring - provides abstraction - focus on business and not repetitive logic - No boilerplates - No need for heavy server i.e. web sphere
2. Lightweight nature - small and broken war - only components to make application run - no useless jar
3. Management of runtime dependencies - manage at runtime - already managed by Spring & IOC container

## IOC - inversion of control

Central IOC container manages all object construction - references the objects and passes to classes which need it as dependency.

- Maintains class dependencies + injects object at runtime not compile time
- Object accepts dependencies for construction instead of constructing it
- Reduces noise in code → not copying and pasting the code - we focus on API contract
- Reduce coupling - doesn't need how to create dependencies - accept dependency already constructed and use dependency api

## Application context

- Heart of spring application + Encapsulates the BeanFactory
- Metadata for bean construction + create bean in correct order
- Handles all singleton beans

Use a platform-bom - work with the same version - ensure all the other spring import work compatibly

Spring Core 

Spring Beans - comes from spring framework

Spring Context

commons-logging

## Spring-Data

- Umbrella of several projects - spring-data home page - all depend on commons - abstract from any particular data source -
- Business entities → Persistent target data, add, delete + save
- Repository pattern + CRUD → Spring dataJPA → JPARepository,GemfireRepository, MongoDBRepository - all extends basic repository
- ORM - mapping physical to logical model
    - Physical model - DB
    - Logical Model - Java class
- Hibernate, Toplink, IBatis → Implementation of JPA
    - JSR317 → JPA - Specification - meta data
    - Hibernate → Provides an implementation