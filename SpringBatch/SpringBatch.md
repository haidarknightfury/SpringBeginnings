## Spring Batch On the JVM 

- Understand how to extend the framework
- Batch Processing - finite amount of data processing without interruption - intented to be finite ; processing should eventually end
- Without Interaction/Interruption -> Unlike webapplication which waits for requests/external stimilus
- Batch Processing -> No external stimulus
- Hadoop/Big Data Processing -> Use of Batch Processing [MapReduce]


## Use Cases

1. ETL -> Extract Transform and Load
2. Reporting -> bills
3. Data Science
4. Big Data -> Hadoop Eco System -> Importing of Data, Orchestration of Data and Extraction
5. Non-Interactinve Processing.


## Spring Batch

- Leading Batch API -> Basis of JSR-352
- Collaboration btw Accenture and Spring
- Features 
    -  1. Job Flow State Machine - A job is a flow; collection of independent processing steps; transitions from steps - all the transition is handled by spring batch
    -  2. Transaction Handling - Handled by Spring Batch - Facilities for breaking into chunks and can restart at point of failures
    -  3. Declarative I/O - Readers and writers and processors - Implement only business logic
    -  4. Robus Error Handling - Minimise the impact of errors
    -  5. Scalability Options - Withing a Single JVM or Multiple JVM
    -  6. Battle Tested - Used in many environments; well tested and vetted
    -  7. Built on Spring. IDE integratinos + Testing Utilities.

 