# SPRING REACTIVE API ( spring 5 ) 
Running spring-reactive-mongoapi
```
cd microservices-data

mvn clean install

To run spring-reactive-mpongoapi

cd microservices-api/spring-reactive-mongoapi/

Run ApplicationShop.java ( from com.inti.formation.shop.api )
```

Creating image docker 
* Image will be created from  Dockerfile
```
cd  spring-reactive-mongoapi
mvn clean install
docker build -t api:latest .
```

commande de création du topic kafka : 

$ kafka-topics --create --topic  deleted-stock-v1  --zookeeper zookeeper:2181 --config cleanup.policy=delete  --config delete.retention.ms=604800000   --config  retention.ms=604800000  --partitions 3  --replication-factor 1

Test Antoine
Test Marion

