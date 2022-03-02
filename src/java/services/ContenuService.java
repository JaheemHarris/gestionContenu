/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import databases.DbAccess;
import dbtable.DbTable;
import java.util.ArrayList;
import java.util.List;
import models.Contenu;
import models.ContenuDetails;
import models.Recherche;

/**
 *
 * @author HP
 */
public class ContenuService {
    
    public ArrayList<ContenuDetails> getListeContenu() throws Exception{
        ArrayList<ContenuDetails> lesContenus = new ArrayList();
        try{
            DbAccess dbConnex = new DbAccess();
            ContenuDetails search = new ContenuDetails();
            List<DbTable> result = new ArrayList();
            result = search.find(search, dbConnex.getConnection());
            ContenuDetails contenu = null;
            for(int i=0;i<result.size();i++){
                contenu = (ContenuDetails)result.get(i);
                lesContenus.add(contenu);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return lesContenus;
    }
    
    public ArrayList<ContenuDetails> getRechercherContenu(Recherche recherche) throws Exception{
        ArrayList<ContenuDetails> lesContenus = new ArrayList();
        DbAccess dbAccess = new DbAccess();
        try{
            lesContenus = recherche.getRechercherContenu(dbAccess);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return lesContenus;
    }
    
    public ContenuDetails getContenu(Integer id) throws Exception{
        DbAccess db = new DbAccess();
        ContenuDetails content = null;
        try{
            ContenuDetails temp = new ContenuDetails();
            temp.setIdContenu(id);
            ArrayList<DbTable> contents = temp.find(temp, db.getConnection());
            if(contents.size()>0)
                content = (ContenuDetails) contents.get(0);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return content;
    }
    
    public Contenu getContenuById(Integer id) throws Exception{
        DbAccess db = new DbAccess();
        Contenu content = null;
        try{
            Contenu temp = new Contenu();
            temp.setId(id);
            ArrayList<DbTable> contents = temp.find(temp, db.getConnection());
            if(contents.size()>0)
                content = (Contenu) contents.get(0);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return content;
    }
}
