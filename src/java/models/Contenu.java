/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dbtable.DbTable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HP
 * 
 */
public class Contenu extends DbTable{
    private Integer id;
    private Integer idType;
    private Integer idUser;
    private String titre;
    private String description;
    private String fichier;
    private String datePublication;

    public Contenu() {
    }

    public Contenu(Integer id) {
        this.id = id;
    }

    public Contenu(Integer id, Integer idType, Integer idUser, String titre, String description, String fichier) {
        this.id = id;
        this.idType = idType;
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.fichier = fichier;
    }

    public Contenu(Integer id, Integer idType, Integer idUser, String titre, String description, String fichier, String datePublication) {
        this.id = id;
        this.idType = idType;
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.fichier = fichier;
        this.datePublication = datePublication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = Integer.parseInt(id.toString());
    }

    public Integer getIdType() {
        return idType;
    }
    
    public void setIdType(Object idType) {
        this.idType = Integer.parseInt(idType.toString());
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
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        LocalDate currentLocalDate = LocalDate.now();
//        System.out.println("DatePublication="+datePublication);
//        this.datePublication = dateFormatter.format(currentLocalDate);
          this.datePublication=datePublication.toString();
    }
    public Integer getIdUser(){
        return this.idUser;
    }
    
    public void setIdUser(Object idUser){
        this.idUser = Integer.parseInt(idUser.toString());
    }
}
