### Microservice

* *name* : micro-state-tracker
* *type* : api 
* *internal port* : 4567
* *external port* : 3001

```
$ docker build -t micro_state_tracker .
```

### Run the container

```
docker run --name micro_state_tracker -p 3001:4567 -d micro_state_tracker
```

### Test the functions

* curl /
* curl -X POST \
    /v1/track/write \
    -H 'cache-control: no-cache' \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'base64keyFile=L2t1YmVybmV0ZXMudHh0&base64contentFile=dGhpcyBpcyBteSBmaXJzdCB0cmFjaw%3D%3D'
* curl /v1/track/read/:base64KeyFile

#### IntelliJ tip to compile

* File > project structure > project language level > 8. Lambda ...
* File > project structure > module > language level > 8. Lambda
* File > settings > compiler > java compiler > 1.8