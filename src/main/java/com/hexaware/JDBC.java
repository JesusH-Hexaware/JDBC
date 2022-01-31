package com.hexaware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) {
        createDatabase();
    }

    public static void createDatabase(){
        Connection conexion = null;
        Statement stmt = null;
        String newDatabaseName = "testDatabase";

        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Spellbook.10");
            stmt = conexion.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + newDatabaseName);
            System.out.println(newDatabaseName + " Database created!");
        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1007){
                //Database already exists error
                System.out.println(sqlException.getMessage());
            }else{
            sqlException.printStackTrace();
            }
        }
    }
}
