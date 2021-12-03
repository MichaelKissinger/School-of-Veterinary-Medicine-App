package com.example.project.model;

import java.sql.*;

public class UserDB {
    Connection connection;
    ResultSet rs;

    public void createConnection() {
        try {
            //You may have to enter your own SQL password below to make this work
            connection = DriverManager.getConnection("jdbc:mysql://localhost/VETMEDICINARYDB", "root", "9788");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int validateUser(int username, int pass) {
        int flag = -1;
        try {

            createConnection();
            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM USER WHERE Password = \"" + pass + "\" AND UserID = \"" + username + "\";");

            if (rs.next())
                flag = 1;
            else flag = 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String getUserInfo(int username, int pass, String column) {
        StringBuffer userInformation = new StringBuffer();

        try {
            createConnection();
            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM USER WHERE Password = \"" + pass + "\" AND UserID = \"" + username + "\";");

            if (rs.next())
                userInformation.append(rs.getString(column));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInformation.toString();
    }

    public String getPermissionType(int username) {
        String permissionType = "";

        try {
            createConnection();
            Statement myStmt = connection.createStatement();
            String[] permissionList = {"Admin", "TEACHER_TECHNICIAN", "CARE_ATTENDANT", "HEALTH_TECHNICIAN", "STUDENT"};
            for (String permission : permissionList) {
                rs = myStmt.executeQuery("SELECT * FROM " + permission + " WHERE UserID = \"" + username + "\";");
                if (rs.next()) {

                    permissionType = rs.getString("Permission");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionType;
    }

    public String adminAccessGetUser() {
        StringBuffer result = new StringBuffer();
        try {
            createConnection();
            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM USER ;");

            while (rs.next())
                result.append(rs.getString("userID") + " " + rs.getString("Password") + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public String adminAccessGetAnimal() {
        StringBuffer result_animal = new StringBuffer();
        try {
            createConnection();
            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM ANIMAL ;");

            while (rs.next())
                result_animal.append(rs.getString("Animal_ID") + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_animal.toString();
    }

    public void updateUserInfo(String username, String pass, String column, String update) {
        try {
            createConnection();
            Statement myStmt = connection.createStatement();

            myStmt.executeUpdate("UPDATE USER SET " + column + " = \"" + update + " \" WHERE UserID = " + username + " AND Password = " + pass + ";");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void deleteUser(String user, String pass) {
        try {
            createConnection();
            Statement myStmt = connection.createStatement();

            myStmt.executeUpdate("DELETE FROM USER WHERE UserID = " + user + " AND Password = " + pass + ";");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
