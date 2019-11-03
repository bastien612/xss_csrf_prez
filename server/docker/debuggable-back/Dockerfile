FROM maven:3.6.1-jdk-8-alpine

RUN mkdir /app

COPY . /app
COPY ./docker/debuggable-back/entrypoint.sh /app/entrypoint.sh

RUN dos2unix /app/entrypoint.sh

WORKDIR /app
# VOLUME /app/entrypoint.sh

ENTRYPOINT ["sh", "/app/entrypoint.sh"]