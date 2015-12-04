DROP TABLE IF EXISTS players;
DROP TABLE IF EXISTS Properties;

SET foreign_key_checks = 0;

CREATE TABLE players(ID INT NOT NULL AUTO_INCREMENT, 
	name VARCHAR(25), 
	money INT, 
	position VARCHAR(25), 
	token VARCHAR(15),
	PRIMARY KEY (ID));

CREATE TABLE properties(ID INT NOT NULL AUTO_INCREMENT,
	own INT, PRIMARY KEY(ID), 
	FOREIGN KEY(own) REFERENCES players(ID));

SET foreign_key_checks = 1;