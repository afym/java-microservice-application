### Autoscaling

* You need have to installed heapster before run
* 200m = 200 millicpu (or also 200 milicores)
* 200m <> 20% CPU

```
$ kubectl create -f scaling-deployment.yml
$ kubectl create -f scaling-service.yml
$ kubectl create -f scaling-autoscaler.yml
```

#### Testing the 

```
# stress test to autoscaling
$ jmeter -n -t scaling.jmx  \
-Jusers=<users> \
-Jperiod=<period> \
-Jcount=<count> \
-Jelb=<elb>
```