/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import databases.DbAccess;
import dbtable.DbTable;
import java.util.ArrayList;
import models.TypeContenu;

/**
 *
 * @author HP
 */
public class TypeService {
    public ArrayList<TypeContenu> getListeType() throws Exception{
        ArrayList<TypeContenu> lesTypes = new ArrayList();
        try{
            DbAccess dbConnex = new DbAccess();
            TypeContenu type = new TypeContenu();
            ArrayList<DbTable> liste = type.find(type, dbConnex.getConnection());
            for(int i=0;i<liste.size();i++){
                lesTypes.add((TypeContenu)liste.get(i));
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return lesTypes;
    }
}
