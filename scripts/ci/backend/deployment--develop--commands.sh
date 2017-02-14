#!/usr/bin/env bash
set -x

docker login -e infos-lille@zenika.com -u $DOCKER_USER -p $DOCKER_PASS
docker tag zenika/lunchplace_backend:ci-$(cat backend/build/version.txt) zenika/lunchplace_backend:develop-$(cat backend/build/version.txt)
docker images
docker push zenika/lunchplace_backend:develop-$(cat backend/build/version.txt)
cd deployment/rancher/envs/lunchplace-staging
${HOME}/${CIRCLE_PROJECT_REPONAME}/tools/rancher-compose --access-key $RANCHER_ACCESS_KEY --secret-key $RANCHER_SECRET_KEY --project-name lunchplace-staging up --force-upgrade --pull -d backend:
${HOME}/${CIRCLE_PROJECT_REPONAME}/tools/rancher-compose --access-key $RANCHER_ACCESS_KEY --secret-key $RANCHER_SECRET_KEY --project-name lunchplace-staging up --confirm-upgrade -d backend:
