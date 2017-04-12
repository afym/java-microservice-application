### Microservice

* *name* : micro-api-countries
* *type* : api 
* *internal port* : 4567
* *external port* : 3000

```
$ docker build -t micro-api-countries .
```

### Run the container

```
$ docker run -d -p 4567:4567 microservice-spark
```

### Test the functions

* curl localhost/
* curl localhost/v1/products

### Stop the container

```
$ docker rm <container-id> -f
```

### IntelliJ tip to compile

* File > project structure > project language level > 8. Lambda ...
* File > project structure > module > language level > 8. Lambda
* File > settings > compiler > java compiler > 1.8