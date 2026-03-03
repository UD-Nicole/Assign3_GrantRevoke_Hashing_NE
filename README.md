Application Security Assignment 3: Hashing & Database Permissions
Student Name: Nicole

College: Georgian College

Project Overview
This project demonstrates a secure user registration system using a Java EE web application. It focuses on protecting user data through cryptographic hashing and implementing the Principle of Least Privilege at the database level.

Implemented Security Features
1. Password Hashing (MD5)
Instead of storing passwords in plain text, this application uses the java.security.MessageDigest class to generate an MD5 hash.

The resulting 32-character hexadecimal string (e.g., cc03e747...) is what is stored in the database, protecting users in the event of a data breach.

2. SQL Injection Prevention
All database interactions utilize Prepared Statements (PreparedStatement).

This ensures that user-supplied input is treated strictly as data, preventing attackers from executing malicious SQL commands.

3. Database Hardening (Grant/Revoke)
A dedicated database user, nets1038_w2026_NE, was created to handle application requests.

Following the Principle of Least Privilege, this user is restricted to only SELECT and INSERT permissions on the registration table.

Administrative privileges and destructive commands (like DROP or DELETE) are strictly forbidden for this user account.

Technology Stack
Java SDK: Version 25

Server: Apache Tomcat 11

Database: MySQL 8.0

IDE: Eclipse
