/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DbAccess {
    private Connection connection=null;
    
    public Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/gestionContenu","root","root");
            connection.setAutoCommit(false);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
    
    public void closeConnection()throws Exception{
        try{
            if(connection!=null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
}
