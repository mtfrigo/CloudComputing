# DynamoDB

## Local

Download the .tar.gz file from https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html

`tar xvzf file.tar.gz`

To run:

`java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb`

*Always use --endpoint-url http://localhost:port for local usage*

* Create-table

``` 
aws dynamodb create-table --table-name shopping-cart --attribute-definitions AttributeName=item,AttributeType=S --key-schema AttributeName=item,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://localhost:8000
```
* List-tables

`aws dynamodb list-tables --endpoint-url http://localhost:8000`