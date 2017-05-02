## Microservices project demonstration

### Microservices list

* micro_api_countries
* micro_db_countries

#### Setting up in local environment with docker compose

To start:

```
$ docker-compose build
$ docker-compose up -d
```
To stop:

```
$ docker-compose down
```

#### Setting up in kubernetes

Build and push images to ECR (Elastic container registry)

For micro_api_countries:

```
$ aws ecr get-login --region <region>
$ docker login -u AWS -p eyJwY.....zonaws.com
$ cd micro-api-countries/
$ docker build -t micro_api_countries .
$ docker tag micro_api_countries:latest <ecr>.amazonaws.com/micro_api_countries:latest
$ docker push <ecr>.amazonaws.com/micro_api_countries:latest
```

For micro_db_countries:

```
$ aws ecr get-login --region <region>
$ docker login -u AWS -p eyJwY.....zonaws.com
$ cd micro-db-countries/
$ docker build -t micro_db_countries .
$ docker tag micro_db_countries:latest <ecr>.amazonaws.com/micro_db_countries:latest
$ docker push <ecr>.amazonaws.com/micro_db_countries:latest
```

For micro_state_tracker:

```
$ aws ecr get-login --region <region>
$ docker login -u AWS -p eyJwY.....zonaws.com
$ cd micro-db-countries/
$ docker build -t micro_state_tracker .
$ docker tag micro_state_tracker:latest <ecr>.amazonaws.com/micro_state_tracker:latest
$ docker push <ecr>.amazonaws.com/micro_state_tracker:latest
```

For micro_stress_cpu:

```
$ aws ecr get-login --region <region>
$ docker login -u AWS -p eyJwY.....zonaws.com
$ cd micro-db-countries/
$ docker build -t micro_stress_cpu .
$ docker tag micro_stress_cpu:latest <ecr>.amazonaws.com/micro_stress_cpu:latest
$ docker push <ecr>.amazonaws.com/micro_stress_cpu:latest
```

Variables :

* Replace the **{{account-id}}**
* Replace the **{{region}}**
* Replace the **{{docker-auth-base64}}**

Running the build.sh to generate the yml files :

```
$ ./build.sh 71727277 us-west-2 ehAi82...9= a27b2d....8db
```

Using the kubectl to deploy the application :

```
# creating the base64 for the aws-ecr-credentials.yml
$ cat ~/.docker/config.json | base64 -w 0
# creating the aws ecr credentials in the cluster (login first with $ docker login ...)
$ kubectl create -f aws-ecr-credentials.yml
# creating the secrets for the deploy
$ kubectl create -f kubernetes/countries-secret.yml
# sample output
$ kubectl get secrets
    NAME                     TYPE                                  DATA      AGE
    default-token-cn7zv      kubernetes.io/service-account-token   3         1h
    mini-db-country-secret   Opaque                                4         5m
    aws-ecr                  kubernetes.io/dockerconfigjson        2         5m
# launch a deployment
$ kubectl create -f kubernetes/countries-deployment.yml
# sample output
    deployment "countries-deployment" created
# launch a service
$ kubectl create -f kubernetes/countries-service.yml

# working with volumes
$ kubectl create -f kubernetes/countries-volume-efs.yml

```

Testing the public api via ELB:

```
$ curl http://<your-elb>.us-west-2.elb.amazonaws.com/
$ curl http://<your-elb>.us-west-2.elb.amazonaws.com/v1/countries
$ curl http://<your-elb>.us-west-2.elb.amazonaws.com/v1/countries/1/cities
$ curl http://<your-elb>.us-west-2.elb.amazonaws.com/v1/countries/1/populations
```

#### Jmeter stress test (optional):

Replace the **{{elb}} and {{region}}** (manually in the operations/jmeter.test/micro-api-country.jmx)

```
# jmeter for micro api countries
$ jmeter -n -t operations/jmeter.test/micro-api-country.jmx
# stress test to autoscaling
$ jmeter -n -t operations/jmeter.test/stress-test.jmx  \
-Jusers=<users> \
-Jperiod=<period> \
-Jcount=<count> \
-Jelb=<elb> \
-Jcpu=<cpu> \
-Jtimeout=<timeout>
```