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

echo "pout"
mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8000 -Dspring.profiles.active=dev -Dspring.devtools.restart.enabled=true"