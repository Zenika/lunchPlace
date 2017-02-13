#!/usr/bin/env bash

set -x
set -e

docker version
docker pull metahelicase/gradle:3.1
bash ./deployment/rancher/scripts/install-rancher-compose.sh
${HOME}/${CIRCLE_PROJECT_REPONAME}/tools/rancher-compose --version