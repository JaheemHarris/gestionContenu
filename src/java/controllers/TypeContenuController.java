/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classUtils.MapView;
import databases.DbAccess;
import dbtable.DbTable;
import java.util.ArrayList;
import java.util.HashMap;
import models.TypeContenu;
import services.TypeService;
import urlAnnotation.URL;

/**
 *
 * @author HP
 */
public class TypeContenuController {
    private TypeContenu typeContenu;
    
    private TypeService typeService;

    public TypeContenu getTypeContenu() {
        return typeContenu;
    }

    public void setTypeContenu(TypeContenu typeContenu) {
        this.typeContenu = typeContenu;
    }
    
    @URL(urlMapping="")
    public MapView getListeTypeContenu()throws Exception{
        MapView mapView = null;
        try{
            typeService = new TypeService();
            ArrayList<TypeContenu> listeType = new ArrayList();
            listeType = typeService.getListeType();
            mapView = new MapView();
            HashMap map = new HashMap();
            map.put("listeType", listeType);
            mapView.setMap(map);
            mapView.setPage("ajoutContenu.jsp");
        }catch(Exception e){
            throw e;
        }
        return mapView;
    }
}
