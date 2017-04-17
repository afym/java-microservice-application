FROM mysql:5.6

ADD data/database.sql /docker-entrypoint-initdb.d/database.sql

EXPOSE 3306

CMD ["mysqld"]