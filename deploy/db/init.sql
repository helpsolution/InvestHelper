CREATE DATABASE invest_helper;

CREATE USER app_user WITH PASSWORD 'pwd';
GRANT ALL PRIVILEGES ON DATABASE invest_helper to app_user;