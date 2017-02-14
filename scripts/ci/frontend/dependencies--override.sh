#!/usr/bin/env bash
set -x

if [ -f build-frontend.txt ]; then
    cd frontend-web
    npm install
else
    echo "nothing to do"
fi