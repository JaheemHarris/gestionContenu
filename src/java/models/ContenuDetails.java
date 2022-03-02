/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dbtable.DbTable;

/**
 *
 * @author HP
 */
public class ContenuDetails extends DbTable{
    private Integer idContenu;
    private Integer idType;
    private String type;
    private Integer idUser;
    private String nom;
    private String prenom;
    private String titre;
    private String description;
    private String fichier;
    private String datePublication;

    public ContenuDetails() {
    }

    public ContenuDetails(Integer idContenu, Integer idType, String type, Integer idUser, String nom, String prenom, String titre, String description, String fichier, String datePublication) {
        this.idContenu = idContenu;
        this.idType = idType;
        this.type = type;
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.description = description;
        this.fichier = fichier;
        this.datePublication = datePublication;
    }

    public Integer getIdContenu() {
        return idContenu;
    }

    public void setIdContenu(Object idContenu) {
        this.idContenu = Integer.valueOf(idContenu.toString());
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Object datePublication) {
        this.datePublication = datePublication.toString();
    }   
}
