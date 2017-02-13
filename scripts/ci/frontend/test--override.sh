#!/usr/bin/env bash

set -x

if [ -f build-frontend.txt ]; then
    cd frontend-web
    npm run build --env=dev
else
    echo "Noting to do"
fi