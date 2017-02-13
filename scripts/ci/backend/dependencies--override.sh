set -x

docker run --rm -v `pwd`:/project --workdir /project/backend -u `id -u`:`id -g` metahelicase/gradle:3.1 --no-daemon --console plain build