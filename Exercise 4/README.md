# Requirements

[Java OpenJDK 1.8](../Guides/jdk.md)

[Tomcat 9](../Guides/tomcat.md)

[Maven](../Guides/maven.md)

[DynamoDB](../Guides/dynamodb.md)

# Exercise 4

* Running DynamoDB locally

```
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

*Create dynamodb table*

`aws dynamodb create-table --table-name shopping-cart --attribute-definitions AttributeName=item,AttributeType=S --key-schema AttributeName=item,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://localhost:8000`

* Running project

*Using port 8060 (can change by modifying src/resources/application.properties)*

```
mvn clean install
java -jar target/exercise-four-0.0.1-SNAPSHOT.jar
```

Go to http://localhost:8060/
