/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classUtils.MapView;
import databases.DbAccess;
import dbtable.DbTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import models.Contenu;
import services.ContenuService;
import urlAnnotation.URL;

/**
 *
 * @author HP
 */
@MultipartConfig
public class ContenuController {
    private Contenu contenu;
    
    private static String uploadPath = "C:\\Users\\HP\\Documents\\NetBeansProjects\\gestionContenu\\web\\uploads\\";

    public Contenu getContenu() {
        return contenu;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }
    
    @URL(urlMapping="inserer")
    public MapView ajouter(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MapView mapView = new MapView();
        try{
            DbAccess dbConnex = new DbAccess();
            Contenu content = this.getContenu();
            HttpSession session = request.getSession();
            Integer idUser = Integer.parseInt(session.getAttribute("user").toString());
            content.setIdUser(idUser);
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) uploadDir.mkdir();
            Part filePart = request.getPart("contenu.fichier");
            String fileName = filePart.getSubmittedFileName();
            content.setFichier(filePart.getSubmittedFileName());
            if(fileName.compareToIgnoreCase("")!=0)
                filePart.write(uploadPath+File.separator+fileName);
            content.insert(dbConnex.getConnection());
            System.out.println("File uploaded!");
            mapView.setPage("/ajoutContenuPage.do");
        }catch(Exception e){
            throw e;
        }
        return mapView;
    }
    
    @URL(urlMapping="delete")
    public MapView supprimer() throws Exception{
        MapView mapView = new MapView();
        try{
            DbAccess dbConnex = new DbAccess();
            Contenu content = this.getContenu();
            content.delete(dbConnex.getConnection());
            mapView.setPage("/lesContenus.do");
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return mapView;
    }
    
    @URL(urlMapping="update")
    public MapView modifier() throws Exception{
        MapView mapView = new MapView();
        try{
            ContenuService contentService = new ContenuService();
            DbAccess dbConnex = new DbAccess();
            Contenu content = this.getContenu();
            Contenu myContent = contentService.getContenuById(content.getId());
            content.setDatePublication(myContent.getDatePublication());
            content.setIdType(myContent.getIdType());
            content.setIdUser(myContent.getIdUser());
            if(content.getFichier().equals(""))
                content.setFichier(myContent.getFichier());
            content.update(dbConnex.getConnection());
            mapView.setPage("/lesContenus.do");
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return mapView;
    }
    
    @URL(urlMapping="download")
    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String filePath = uploadPath+contenu.getFichier();
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        ServletContext context = request.getServletContext();
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        PrintWriter outStream = response.getWriter();
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read()) != -1) {
            outStream.write(bytesRead);
        }
         
        inStream.close();
        outStream.close();
    }
}
