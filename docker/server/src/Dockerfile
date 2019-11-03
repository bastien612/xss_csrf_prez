FROM openjdk:8u201-jdk-alpine3.9

RUN mkdir /app

COPY ./checklist-server.jar /app/checklist-server.jar
COPY entrypoint.sh /app/entrypoint.sh

RUN dos2unix /app/entrypoint.sh

RUN addgroup -g 1000 check && \
    adduser -D -u 1000 -G check check && \
    chown check:check -R /app && \
    chmod 700 -R /app

WORKDIR /app
USER check

ENTRYPOINT ["sh", "/app/entrypoint.sh"]