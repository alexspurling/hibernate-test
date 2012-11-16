# Hibernate test project

This is a project to test the apparently simple case of mapping two entities that have a one to one relationship. In
this example we have two entities Person and Address and a schema with two corresponding tables:

'''
------------
|Person    |
|----------|
|id        |
|first_name|
|last_name |
------------

-----------
|Address  |
|---------|
|person_id|
|street   |
|town     |
|postcode |
-----------
'''

To run this code, you have to have Maven and Mysql installed.

First, set up the test database by running the following commands in mysql:

'''
create user 'testuser'@'localhost' identified by 'password';
create database hibernatetest;
grant all on hibernatetest.* to testuser@localhost;
'''

Then, run:

'''
mvn clean test
'''
