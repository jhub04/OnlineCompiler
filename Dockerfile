FROM openjdk:17
WORKDIR /app
COPY run.sh /app/run.sh
RUN chmod +x /app/run.sh
CMD ["/bin/sh", "/app/run.sh"]