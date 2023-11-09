#!/bin/bash
RELEASE=$1

if [[ ! "$RELEASE" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
    echo "**********************************"
    echo "* Invalid release version format *"
    echo "**********************************"
    exit 1
fi

DIR=$(pwd)
mvn clean install -DskipTests
mkdir -p $DIR/build
mv $DIR/target/picco-cli-$RELEASE.jar $DIR/build

GITHUB_TOKEN=$(cat ~/.github_terraform_token)
terraform apply -var="github_token=${GITHUB_TOKEN}"