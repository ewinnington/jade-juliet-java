# jade-juliet-java
 implementations in multiple languages of common tasks: REST Api Host / Client, Database access, Postgresql, Redis access, Rabbit MQ

## Generating a basic java application with Maven 

[From Tutorial](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

 mvn archetype:generate -DgroupId=com.cloudplush.hw -DartifactId=my-hw -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

 cd my-hw 
 mvn package

 java -cp target/my-hw-1.0-SNAPSHOT.jar com.cloudplush.hw.App

 ## Redis connection 

mvn archetype:generate -DgroupId=com.cloudplush.code -DartifactId=cli-redis -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

```xml
 <!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
    <dependency>
      <groupId>redis.clients</groupId>
      <artifactId>jedis</artifactId>
      <version>3.3.0</version>
    </dependency>
```

mvn package
mvn clean install -U dependency:copy-dependencies

java -cp "target/dependency/*:target/cli-redis-1.0-SNAPSHOT.jar" com.cloudplush.code.App


## Postgresql connection 

mvn archetype:generate -DgroupId=com.cloudplush.code -DartifactId=cli-pgsql -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

```xml
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.16</version>
</dependency>
```
mvn package
mvn clean install -U dependency:copy-dependencies

java -cp "target/dependency/*:target/cli-pgsql-1.0-SNAPSHOT.jar" com.cloudplush.code.App