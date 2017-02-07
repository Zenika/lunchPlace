set -x
set -e

readonly RANCHER_COMPOSE_VERSION=0.12.0
readonly RANCHER_COMPOSE_DOWNLOAD_URL=https://releases.rancher.com/compose/v${RANCHER_COMPOSE_VERSION}/rancher-compose-linux-amd64-v${RANCHER_COMPOSE_VERSION}.tar.gz
readonly RANCHER_COMPOSE_TGZ=rancher-compose-linux-amd64-v${RANCHER_COMPOSE_VERSION}.tar.gz
readonly RANCHER_COMPOSE_DIRECTORY=rancher-compose-v${RANCHER_COMPOSE_VERSION}

if [ ! -e tools/${RANCHER_COMPOSE_TGZ} ]; then
  mkdir -p tools
  wget -O tools/${RANCHER_COMPOSE_TGZ} ${RANCHER_COMPOSE_DOWNLOAD_URL}
  cd tools
  tar xzf ${RANCHER_COMPOSE_TGZ}
  cp ${RANCHER_COMPOSE_DIRECTORY}/rancher-compose rancher-compose
fi
