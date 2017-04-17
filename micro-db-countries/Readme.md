### Microservice

* *name* : micro-db-countries
* *type* : data repository 
* *internal port* : 3306
* *external port* : 3306

```
$ docker build -t micro_db_countries .
```

### Run the container

```
$ docker run --name micro_db_countries -p 3306:3306 --env-file=environment.db -d micro_db_countries
```