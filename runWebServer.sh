#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
echo "Running 'montis web server' in $DIR"

cd $DIR

./gradlew server:run --args='devMode'