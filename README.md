# Quarkus Tutorial by F.X.

## Prerequistes

- GraalVM 19.3
- Maven 3.6
- Docker

> add `export GRAALVM_HOME=[GraalVM installation folder]
> edit or create your `~/.mavenrc` and add `export JAVA_HOME=$GRAALVM_HOME`

> Tips : use SDKMAN to install GraalVM 19.3


## Running PostgreSQL

```bash
$ docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_tuto -e POSTGRES_USER=quarkus_tuto -e POSTGRES_PASSWORD=quarkus_tuto -e POSTGRES_DB=quarkus_tuto -p 5432:5432 postgres:12.2
```

## Get the source and run the application in dev mode


```bash
$ git clone https://github.com/fxrobin/quarkus-tuto.git
$ cd quarkus-tuto
$ mvn quarkus:dev
```

## Send REST Get request

Check if the application is running :

```
$ curl http://localhost:8080/api/ping/v1
```

Send usefull requests :


```
$ curl http://localhost:8080/api/videogames/v1
```

or

```
$ curl http://localhost:8080/api/videogames/v1/genre/shoot-them-up
```

or 

```
$ curl http://localhost:8080/api/videogames/v1/genre/pinball
```

## Running integration tests

> Note : PostgreSQL must **NOT** be running because the `verify` goal will launch a containerized PostgreSQL with Docker.

```
$  mvn verify -Dskip.surefire.tests
```

## Generate and test de native build

> Note : PostgreSQL must be running

```bash
$ mvn clean package -Pnative -Dmaven.test.skip=true
```

## Run the native application

```
$ ./target/quarkus-tuto-0.0.1-SNAPSHOT-runner
```

> send HTTP Get requests as describes § '*Send REST Get request*'



