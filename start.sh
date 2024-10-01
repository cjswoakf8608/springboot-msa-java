#!/bin/bash

set -e

# 프로젝트 루트 디렉토리로 이동
cd "$(dirname "$0")"

# 각 모듈 빌드 실행
(cd apis/apps && ./gradlew clean bootJar --no-daemon)
(cd apis/payments && ./gradlew clean bootJar --no-daemon)
(cd cores/core-products && ./gradlew clean bootJar --no-daemon)
(cd cores/core-users && ./gradlew clean bootJar --no-daemon)
(cd wordkers && ./gradlew clean bootJar --no-daemon)

# docker-compose 실행
docker-compose up --build
