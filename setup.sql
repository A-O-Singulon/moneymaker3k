-- Create the database
CREATE DATABASE IF NOT EXISTS scorenerds;

-- Create the user and grant privileges
CREATE USER 'scorenerd'@'localhost' IDENTIFIED BY 'scorenerd123';
GRANT ALL PRIVILEGES ON scorenerds.* TO 'scorenerd'@'localhost';
FLUSH PRIVILEGES;

-- Use with:
-- mysql -u root -p < setup.sql
