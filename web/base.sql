/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  HP
 * Created: 15 déc. 2021
 */

CREATE TABLE typeContenu(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type VARCHAR(255)
);

INSERT INTO typeContenu VALUES (1,'PV');
INSERT INTO typeContenu VALUES (2,'Rapport de mission');
INSERT INTO typeContenu VALUES (3,'Note interne');
INSERT INTO typeContenu VALUES (4,'Evenement');

CREATE TABLE utilisateur(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO utilisateur (nom,prenom,email,password) VALUES ("Jaheem","Harris","jaheemharris@gmail.com",sha1("jaheemharris"));
INSERT INTO utilisateur (nom,prenom,email,password) VALUES ("Jean","Lucien","jeanlucien@gmail.com",sha1("jeanlucien"));
INSERT INTO utilisateur (nom,prenom,email,password) VALUES ("Jonah","Fitia","jonahfitia@gmail.com",sha1("jonahfitia"));
INSERT INTO utilisateur (nom,prenom,email,password) VALUES ("Tommy","Zafy","tommyzafy@gmail.com",sha1("tommyzafy"));

CREATE TABLE contenu(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idType INT NOT NULL,
    idUser INT NOT NULL,
    titre VARCHAR(255),
    description VARCHAR(255),
    fichier VARCHAR(255),
    datePublication DATETIME,
    FOREIGN KEY (idType) REFERENCES typeContenu(id),
    FOREIGN KEY (idUser) REFERENCES utilisateur(id)
)ENGINE=InnoDb;


INSERT INTO contenu(idType,idUser,titre,description,fichier,datePublication) VALUES (2,2,'Sponsor','Deplacement paris','Ble.xlsx','2022/01/02');
INSERT INTO contenu(idType,idUser,titre,description,fichier,datePublication) VALUES (1,3,'Test PV','Description PV','curve.txt','2021/11/19');
INSERT INTO contenu(idType,idUser,titre,description,fichier,datePublication) VALUES (4,4,'Nouvel an','Fete du nouvel an','Gestion.docx','2022/02/21');

CREATE VIEW contenuDetails AS SELECT c.id as idContenu,t.id as idType,t.type,u.id as idUser,u.nom,u.prenom,c.titre,c.description,c.fichier,c.datePublication 
                                FROM contenu AS c JOIN  typeContenu as t ON c.idType=t.id 
                                JOIN utilisateur AS u ON c.idUser=u.id ORDER BY c.datePublication DESC;