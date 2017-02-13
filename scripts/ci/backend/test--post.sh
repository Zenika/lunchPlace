#!/usr/bin/env bash

set -x

if [ -f build-backend.txt ]; then
    docker images
else
    echo "Noting to do"
fi