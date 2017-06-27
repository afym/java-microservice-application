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


```

```

```
curl -X POST \
  http://state.afym.com//v1/track/write \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: b4f3034a-b2ce-2d86-a8a9-22115e2c6f12' \
  -d 'base64keyFile=amF2YS50eHQ%3D&base64contentFile=c29tZSBsYW5ndWFnZQ%3D%3D'
```

#### IntelliJ tip to compile

* File > project structure > project language level > 8. Lambda ...
* File > project structure > module > language level > 8. Lambda
* File > settings > compiler > java compiler > 1.8