# Requirements

* Java jdk >= 1.8
* Apache Tomcat 9
* Springboot

# DynamoDB

## Installing

TODO

## Running

```
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

# Project

Using springboot and java

Using port 8060 (can change by modifying src/resources/application.properties)

## Running

```
mvn clean install
java -jar target/exercise-four-0.0.1-SNAPSHOT.jar
```
