set foreign_key_checks=0;
DROP TABLE IF EXISTS person;
CREATE TABLE person (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NULL DEFAULT NULL,
    last_name VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS address;
CREATE TABLE address (
    person_id INT(10) NOT NULL,
    street VARCHAR(50) NULL DEFAULT NULL,
    town VARCHAR(50) NULL DEFAULT NULL,
    postcode VARCHAR(50) NULL DEFAULT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE
);
set foreign_key_checks=1;