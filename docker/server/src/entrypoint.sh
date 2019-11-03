#!/usr/bin/env bash

set -e

echo ""
echo "connecting to database: "
while ! nc -z db 5432; do
  echo "waiting for database setup ..."
  sleep 1
done
echo "database is ready."
echo ""

java -jar checklist-server.jar