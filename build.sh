#!/bin/bash

ACCOUNT_ID=$1
REGION=$2
DOCKER_AUTH=$3
EFS_DNS=$4

if [ -d "operations" ]; then
  rm -rf operations/
fi

cp -avr operations_template operations

cd operations/

# deployment
sed -i -e "s@{{account-id}}@${ACCOUNT_ID}@g" "kubernetes/countries-deployment.yml"
sed -i -e "s@{{region}}@${REGION}@g" "kubernetes/countries-deployment.yml"
sed -i -e "s@{{region}}@${REGION}@g" "kubernetes/state-deployment.yml"

# efs
sed -i -e "s@{{efs-dns}}@${EFS_DNS}@g" "kubernetes/state-volume-efs.yml"
sed -i -e "s@{{account-id}}@${ACCOUNT_ID}@g" "kubernetes/state-deployment.yml"
sed -i -e "s@{{region}}@${REGION}@g" "kubernetes/state-deployment.yml"
sed -i -e "s@{{account-id}}@${ACCOUNT_ID}@g" "kubernetes/stress-deployment.yml"
sed -i -e "s@{{region}}@${REGION}@g" "kubernetes/stress-deployment.yml"

# docker auth
sed -i -e "s@{{docker-auth-base64}}@${DOCKER_AUTH}@g" "kubernetes/aws-ecr-credentials.yml"

echo "sed files ... complete!"