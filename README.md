# Quarkus Tutorial with Panache ORM on Openshift

## Generate Project Skeleton

Clone sample source code from

```bash
git clone https://github.com/erfinfeluzy/quarkus-demo.git 
 ``` 
 
Or, generate from project skeleton

```bash
mvn io.quarkus:quarkus-maven-plugin:0.19.1:create \
    -DprojectGroupId=com.erfinfeluzy.demo.quarkus \
    -DprojectArtifactId=quarkus-demo \
    -DclassName="com.erfinfeluzy.demo.quarkus.HelloResource" \
    -Dpath="/hello"
 ```   
    
## Run in DEV mode

```bash
mvn compile quarkus:dev:
```
run on different port
```bash
mvn compile quarkus:dev: -Dquarkus.http.port=8081
```

## Test Locally (with Java Runtime)
```bash
$ curl localhost:8080/api
```

```bash
hello
```

## Try Hot Reload
Change java class, then Quarkus will hot deploy it.

## Build Native Image on GraalVM

### Prerequsite
1. Install [GraalVM](https://www.graalvm.org/docs/getting-started/), set $GRAALVM_HOME

## Build as native GraalVM apps
```bash
mvn package -Pnative
```

## Package as Container Image
```bash
mvn clean package -Dnative -Dquarkus.native.container-build=true
```
Note: i need to increase local docker memory due to OutOfMemoryError during building


```bash
docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus-project .
```

## Run image on local Docker

```bash
docker run -i --rm -p 8080:8080 quarkus/quarkus-project
```

## Push to Quay.io

```bash
docker tag quarkus/quarkus-project quay.io/efeluzy/quarkus-demo-orm:latest

docker push quay.io/efeluzy/quarkus-demo-orm:latest
```

## Deploy to Openshift
### Via Web Console
1. Add To Project > Deploy Image > Image Name > quay.io/efeluzy/quarkus-demo-orm:latest
2. Click Search, Select project
3. Click Deploy
