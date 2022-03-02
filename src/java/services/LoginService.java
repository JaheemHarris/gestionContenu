/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import databases.DbAccess;
import models.Login;
import models.Utilisateur;

/**
 *
 * @author HP
 */
public class LoginService {
    private Login login;
    
    public Utilisateur authenticate() throws Exception{
        Utilisateur user = null;
        try{
            DbAccess dbConnex = new DbAccess();
            String email = login.getEmail();
            String password = login.getPassword();
            UtilisateurService userService = new UtilisateurService();
            user = userService.getUtilisateurByEmailAndPassword(email, password, dbConnex);
        }catch(Exception e){
            throw e;
        }
        return user;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
