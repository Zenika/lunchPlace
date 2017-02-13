#!/usr/bin/env bash
set -x

echo "Listing all diffs"
git diff-tree --no-commit-id --name-only -r ${CIRCLE_SHA1}

git diff-tree --no-commit-id --name-only ${CIRCLE_SHA1} | grep backend
if [ $? == 0 ]; then
    touch build-backend.txt
    echo "Will build backend"
else
    echo "Will NOT build backend"
fi

git diff-tree --no-commit-id --name-only ${CIRCLE_SHA1} | grep frontend-web
if [ $? == 0 ]; then
    touch build-frontend.txt
    echo "Will build frontend"
else
    echo "Will NOT build frontend"
fi