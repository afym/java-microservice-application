### Microservice

* *name* : micro-api-countries
* *type* : api 
* *internal port* : 4567
* *external port* : 3000

```
$ docker build -t micro_api_countries .
```

### Run the container

```
docker run --name micro_api_countries -p 3000:4567 -d micro_api_countries
```

### Test the functions

* curl /
* curl /v1/countries
* curl /v1/countries/:countryId/cities
* curl /v1/countries/:countryId/populations

### Health check endpoint

* curl /v1/health-check

#### IntelliJ tip to compile

* File > project structure > project language level > 8. Lambda ...
* File > project structure > module > language level > 8. Lambda
* File > settings > compiler > java compiler > 1.8