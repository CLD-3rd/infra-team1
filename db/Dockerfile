FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=ottproj
ENV MYSQL_USER=ottp
ENV MYSQL_PASSWORD=ottp

COPY sql/data.sql /docker-entrypoint-initdb.d/
COPY conf/db.conf /etc/mysql/conf.d/
