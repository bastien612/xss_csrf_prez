#!/usr/bin/env bash

set -e

echo ""
echo "Try connecting to database: "
while ! nc -z db 5432; do
  echo "waiting for database setup ..."
  sleep 1
done
echo "database is ready."
echo ""

mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev -Dspring.devtools.restart.enabled=true"