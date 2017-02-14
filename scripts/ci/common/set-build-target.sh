#!/usr/bin/env bash
set -x

echo "Listing all diffs"
git diff-tree --no-commit-id --name-only -r ${CIRCLE_SHA1}
