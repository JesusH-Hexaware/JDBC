package com.hexaware;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBC {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/";
    static String user = "root";
    static String password = "Spellbook.10";
    static String databaseName = "testDatabase";
    static String tableName = "DATASHEET";

    public static void main(String[] args) {
        createDatabase();
        createTable();
        insertInto();

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
        } finally {
            try{
                if (sentencia != null){
                    sentencia.close();
                }
                if (conexion != null){
                    conexion.close();
                }
            } catch (Exception e){
                e.printStackTrace();
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
        } finally {
            try{
                if (sentencia != null){
                    sentencia.close();
                }
                if (conexion != null){
                    conexion.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void insertInto(){
        Connection conexion = null;
        Statement sentencia = null;

        Map<Integer, String> query = new HashMap<>();
        query.put (0, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Spencer','Streich','aliquet.magna@test.io','UJE73DLC2RY','Langworth, Rippin and Pollich','Ap #195-7619 Eget, Street','Bonlez',346624,'1-507-954-4323')");
        query.put (1, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Marion','Mayer','erat.eget.tincidunt@protonmail.edu','BQG27CTE9DU','Stiedemann - Watsica','117-2296 Ut Street','Almere',214821,'(274) 178-1482')");
        query.put (2, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Gabriel','Reilly','mus@yahoo.ca','IKM14NXL3DK','Romaguera','P.O. Box 855, 8605 Magna. Rd.','testCity',98765,'(334) 273-7218')");
        query.put (3, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Malcolm','Jacobs','accumsan@icloud.com','ICW28OOY7AD','Morar, Cole and McCullough','192-3565 In Ave','Cork',591254,'1-344-561-5654')");
        query.put (4, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Neal','Shanahan','pede.cum@outlook.net','OAH76NPM3LW','Kling - Kihn','223-2228 Nulla Road','Göksun',655933,'(658) 455-8896')");
        query.put (5, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Loren','Botsford','diam.duis.mi@aol.edu','RLH68SUK7HZ','Steuber - Bernier','1902 Cum Road','Sefro',547456,'(240) 742-8786')");
        query.put (6, "INSERT INTO DATASHEET (NAME,LASTNAME,EMAIL,PASSWORD,COMPANY,ADDRESS,CITY,ZIP_CODE,MOBILE_PHONE) " +
                "VALUES ('Doug','Gusikowski','montes@protonmail.couk','TBQ37PNL6HM','Hermiston Group','Ap #852-2724 Massa. Av.','Mandya',3193,'(624) 401-6293')");

        try{
            conexion = DriverManager.getConnection(jdbcUrl+databaseName, user, password);
            sentencia = conexion.createStatement();

            for (Map.Entry<Integer, String> entry : query.entrySet()){
                sentencia.executeUpdate(String.valueOf(entry.getValue()));
            }
            System.out.println("Update Successful!");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try{
                if (sentencia != null){
                    sentencia.close();
                }
                if (conexion != null){
                    conexion.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
