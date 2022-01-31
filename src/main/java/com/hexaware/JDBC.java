package com.hexaware;

import java.sql.*;

public class JDBC {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/";
    static String user = "root";
    static String password = "Spellbook.10";
    static String databaseName = "testDatabase";
    static String tableName = "DATASHEET";

    public static void main(String[] args) {
        createDatabase();
        createTable();

    }

    public static void createDatabase(){
        Connection conexion = null;
        Statement sentencia = null;
        String newDatabaseName = "testDatabase";

        try{
            conexion = DriverManager.getConnection(jdbcUrl,user,password);
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("CREATE DATABASE " + newDatabaseName);
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

    public static void createTable() {
        Connection conexion = null;
        Statement sentencia = null;


        String createTable = "CREATE TABLE " + tableName + " (" +
                "NAME VARCHAR(255)," +
                "LASTNAME VARCHAR(255)," +
                "EMAIL VARCHAR(255)," +
                "PASSWORD VARCHAR(255)," +
                "COMPANY VARCHAR(255)," +
                "ADDRESS VARCHAR(255)," +
                "CITY VARCHAR(255)," +
                "ZIP_CODE INT," +
                "MOBILE_PHONE VARCHAR(50))";

        try {
            conexion = DriverManager.getConnection(jdbcUrl + databaseName, user, password);
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(createTable);
            System.out.println("Table Created!");

        } catch (SQLException sqlException) {
            if (sqlException.getErrorCode() == 1050) {
                //Database already exists error
                System.out.println(sqlException.getMessage());
            } else {
                sqlException.printStackTrace();
            }
        }
    }
}
