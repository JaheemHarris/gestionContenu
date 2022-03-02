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
public class TypeContenu extends DbTable{
    private Integer id;
    private String type;

    public TypeContenu() {
    }

    public TypeContenu(Integer id) {
        this.id = id;
    }

    public TypeContenu(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
