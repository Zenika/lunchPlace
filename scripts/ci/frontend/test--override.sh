#!/usr/bin/env bash

set -x

if [ -f build-frontend.txt ]; then
    cd frontend-web
    npm run build --env=dev
    docker build --rm=false -t zenika/lunchplace_frontend:ci-000 .
    docker login -e infos-lille@zenika.com -u $DOCKER_USER -p $DOCKER_PASS
    docker push zenika/lunchplace_frontend:ci-000
else
    echo "Noting to do"
fi