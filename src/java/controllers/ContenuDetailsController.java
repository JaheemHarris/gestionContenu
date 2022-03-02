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
import models.ContenuDetails;
import models.TypeContenu;
import services.ContenuService;
import services.TypeService;
import urlAnnotation.URL;

/**
 *
 * @author HP
 */
public class ContenuDetailsController {
    
    private ContenuDetails contenuDetails;
    private ContenuService contenuService;
    private TypeService typeService;

    public ContenuDetails getContenuDetails() {
        return contenuDetails;
    }

    public void setContenuDetails(ContenuDetails contenuDetails) {
        this.contenuDetails = contenuDetails;
    }
    
    @URL(urlMapping="functionMapping")
    public MapView nomFucntion() throws Exception{
        MapView mapView = new MapView();
        try{
            ArrayList<ContenuDetails> lesContenus = new ArrayList();
            contenuService = new ContenuService();
            lesContenus = contenuService.getListeContenu();
            ArrayList<TypeContenu> listeType = new ArrayList();
            typeService = new TypeService();
            listeType = typeService.getListeType();
            HashMap map = new HashMap();
            map.put("listeContenu", lesContenus);
            map.put("listeType", listeType);
            mapView.setMap(map);
            mapView.setPage("/listeContenu.jsp");
        }catch(Exception e){
            throw e;
        }
        return mapView;
    }
    @URL(urlMapping="mappingFunction")
    public MapView anaranaFonction(){
        MapView mapView = new MapView();
        try{
            ContenuDetails contenu = this.getContenuDetails();
            contenuService = new ContenuService();
            ContenuDetails content = contenuService.getContenu(contenu.getIdContenu());
            HashMap map = new HashMap();
            map.put("contenu", content);
            mapView.setMap(map);
            mapView.setPage("/ficheContenu.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
        return mapView;
    }
    
    @URL(urlMapping="mapiny")
    public MapView functionName(){
        MapView mapView = new MapView();
        try{
            ContenuDetails contenu = this.getContenuDetails();
            contenuService = new ContenuService();
            ContenuDetails content = contenuService.getContenu(contenu.getIdContenu());
            HashMap map = new HashMap();
            map.put("contenu", content);
            mapView.setMap(map);
            mapView.setPage("/modifierContenu.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
        return mapView;
    }
}
