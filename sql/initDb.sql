CREATE DATABASE blog_db;
CREATE USER blog_user WITH PASSWORD 'blog_user';

GRANT ALL PRIVILEGES ON DATABASE blog_db TO blog_user;
ALTER DATABASE blog_db OWNER TO blog_user;

--CREATE SCHEMA IF NOT EXISTS blogs AUTHORIZATION "blog_db_user";
