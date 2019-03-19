CREATE TABLE Opiskelija(
	opiskelijaID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	etunimi VARCHAR(255) NOT NULL,
	sukunimi VARCHAR(255) NOT NULL,
	opintoviikot int
	);
	
	INSERT INTO Henkilo(etunimi,sukunimi,syntvuosi) VALUES ("Ilkka","Nieminen",0),
	("Kaisa","Tamminen",55),("Erkki","Pohjola",100); 