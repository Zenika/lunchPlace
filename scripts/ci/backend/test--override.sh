#!/usr/bin/env bash

set -x

if [ -f build-backend.txt ]; then
    docker run --rm -v `pwd`:/project --workdir /project/backend -u `id -u`:`id -g` metahelicase/gradle:3.1 --no-daemon --console plain writeProjectVersion
    echo "found version $(cat backend/build/version.txt)"
    docker build --rm=false -t zenika/lunchplace_backend:ci-$(cat backend/build/version.txt) backend/
else
    echo "Noting to do"
fi