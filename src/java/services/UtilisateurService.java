/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import databases.DbAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Utilisateur;

/**
 *
 * @author HP
 */
public class UtilisateurService {
    
    public Utilisateur getUtilisateurByEmailAndPassword(String email,String password,DbAccess dbConnex) throws Exception{
        Utilisateur user = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try{
            con = dbConnex.getConnection();
            String sql = "SELECT * FROM utilisateur WHERE email=? AND password=sha1(?)";
            stmt = con.prepareStatement(sql);
            stmt.setObject(1, email);
            stmt.setObject(2, password);
            res = stmt.executeQuery();
            while(res.next()){
                user = new Utilisateur(res.getInt("id"),res.getString("nom"),res.getString("prenom"),res.getString("email"),res.getString("password"));
                break;
            }
        }catch(Exception e){
            throw e;
        }finally{
            if(res!=null)
                res.close();
            if(stmt!=null)
                stmt.close();
            dbConnex.closeConnection();
        }
        return user;
    }
}
