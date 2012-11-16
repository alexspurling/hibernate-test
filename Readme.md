# Hibernate test project

This is a project to test the apparently simple case of mapping two entities that have a one to one relationship. In
this example we have two entities Person and Address and a schema with two corresponding tables:

<table>
<tr><th>Person</th></tr>
<tr><td>id</td></tr>
<tr><td>first_name</td></tr>
<tr><td>last_name</td></tr>
</table>

<table>
<tr><th>Address</th></tr>
<tr><td>person_id</td></tr>
<tr><td>street</td></tr>
<tr><td>town</td></tr>
<tr><td>postcode</td></tr>
</table>

### Running the project

To run this code, you need to have Maven and Mysql installed.

First, set up the test user and database by running the following commands in mysql:

```
create user 'testuser'@'localhost' identified by 'password';
create database hibernatetest;
grant all on hibernatetest.* to testuser@localhost;
```

Then, run:

```
mvn clean test
```
