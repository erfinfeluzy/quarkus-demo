# quarkus-demo

## Generate Project Skeleton

```bash
mvn io.quarkus:quarkus-maven-plugin:0.19.1:create \
    -DprojectGroupId=com.erfinfeluzy.demo.quarkus \
    -DprojectArtifactId=quarkus-demo \
    -DclassName="com.erfinfeluzy.demo.quarkus.HelloResource" \
    -Dpath="/hello"
 ```   
    
## Run in DEV mode
```bash
./mvnw compile quarkus:dev:
```

## Test Locally (with Java Runtime)
```bash
$ curl localhost:8080/hello
```

```bash
hello
```

## Try Hot Reload
Change java class

## Build Native Image on GraalVM

### Prerequsite
1. Install GraalVM, set $GRAALVM_HOME

## Build as native GraalVM apps
```bash
./mvnw package -Pnative
```

## Package as Container Image
```bash
./mvnw package -Pnative -Dnative-image.docker-build=true
```

```bash
docker build -f src/main/docker/Dockerfile.native -t quarkus/quarkus-project .
```

## Run image on local Docker

```bash
docker run -i --rm -p 8080:8080 quarkus/quarkus-project
```

## Push to Quay.io

```bash
docker tag quarkus/quarkus-project quay.io/efeluzy/quarkus-demo:latest

docker push quay.io/efeluzy/quarkus-demo:latest
```

## Deploy to Openshift
### Via Web Console
1. Add To Project > Deploy Image > Image Name > quay.io/efeluzy/quarkus-demo:latest
2. Click Search, Select project
3. Click Deploy
