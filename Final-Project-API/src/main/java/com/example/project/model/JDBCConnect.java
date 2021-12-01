package com.example.project.model;

import java.sql.*;
import java.util.ArrayList;

public class JDBCConnect {

    private Connection dbConnect;

    public void createConnection() {
        try {
            //You may have to enter your own SQL password below to make this work
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/VETMEDICINARYDB", "root", "Katana123!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String animalGetStatement(int animalID, String trait) throws SQLException {
        StringBuffer animalInfo = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM ANIMAL WHERE Animal_ID = \"" + animalID + "\";");

            while (results.next()) {
                animalInfo.append(results.getString(trait));
            }
            myStmt.close();
        }
        catch (SQLException e) {
                e.printStackTrace();
            }
        return animalInfo.toString();
    }

    public void animalSetStatement(int animalID, String column, String change) throws SQLException {
        StringBuffer animalInfo = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            myStmt.executeUpdate("UPDATE ANIMAL SET " + column + " = \"" + change +" \" WHERE Animal_ID = \""+ animalID +"\";");

            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String animalGetPrescription(int animalID, String trait) throws SQLException {
        StringBuffer animalInfo = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM ANIMAL_PRESCRIPTION WHERE Animal_ID = \"" + animalID + "\";");

            while (results.next()) {
                animalInfo.append(results.getString(trait));
            }
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return animalInfo.toString();
    }

    //TO DO
    public void animalAddPrescription(int animalID, String column, String change) throws SQLException {
        StringBuffer animalInfo = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            myStmt.executeUpdate("UPDATE ANIMAL SET " + column + " = \"" + change +" \" WHERE Animal_ID = \""+ animalID +"\";");

            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String animalGetProblem(int animalID, String trait) throws SQLException {
        StringBuffer animalInfo = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM ANIMAL_PROBLEM WHERE Animal_ID = \"" + animalID + "\";");

            while (results.next()) {
                animalInfo.append(results.getString(trait));
            }
            myStmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return animalInfo.toString();
    }



}