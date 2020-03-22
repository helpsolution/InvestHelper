CREATE DATABASE task_helper;

CREATE USER app_user WITH PASSWORD 'pwd';
GRANT ALL PRIVILEGES ON DATABASE task_helper to app_user;