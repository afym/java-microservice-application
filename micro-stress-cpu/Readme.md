### Microservice

* *name* : micro-stress-cpu
* *type* : api 
* *internal port* : 4567
* *external port* : 3002

```
$ docker build -t micro_stress_cpu .
```

### Run the container

```
docker run --name micro_stress_cpu -p 3002:4567 -d micro_stress_cpu
```

### Test the functions

* curl /
* curl /v1/cpu/:cpu/:timeout

#### IntelliJ tip to compile

* File > project structure > project language level > 8. Lambda ...
* File > project structure > module > language level > 8. Lambda
* File > settings > compiler > java compiler > 1.8