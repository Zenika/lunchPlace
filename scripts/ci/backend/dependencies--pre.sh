#!/usr/bin/env bash

set -x
set -e

if [ -f build-backend.txt ]; then
    docker version
    docker pull metahelicase/gradle:3.1
    bash ./deployment/rancher/scripts/install-rancher-compose.sh
    ${HOME}/${CIRCLE_PROJECT_REPONAME}/tools/rancher-compose --version
else
    echo "Noting to do"
fi