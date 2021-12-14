package com.example.project.model;

import java.sql.*;

/**
 * UserDB class is the bridge between backend and database. It has all required
 * functionalities to get information from DB and write information to DB
 *
 * @author Arman Hosseinsarraf
 */
public class UserDB {

    private Connection connection;

    public void createConnection() {
        try {
            // You will have to enter your own SQL password below to make this work
            connection = DriverManager.getConnection("jdbc:mysql://localhost/VETMEDICINARYDB", "root", "Katana123!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ResultSet rs; // build an object of resultSet to store the result of the query

    public UserDB() throws SQLException {
    }

    /**
     * validateUser() checks to see if the given username and password are in the
     * user database
     *
     * @param username
     * @param pass
     * @return
     */
    public int validateUser(int username, int pass) throws SQLException {
        createConnection();
        int flag = -1;
        try {

            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery(
                    "SELECT * FROM USER WHERE Password = \"" + pass + "\" AND UserID = \"" + username + "\";"); // query
            // from
            // DB

            if (rs.next())
                flag = 1;
            else
                flag = 0;

            connection.close();
            myStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * queries the required information related to given username and password
     *
     * @param username
     * @param pass
     * @param column
     * @return
     */
    public String getUserInfo(int username, int pass, String column) throws SQLException {
        createConnection();
        StringBuffer userInformation = new StringBuffer();

        try {

            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery(
                    "SELECT * FROM USER WHERE Password = \"" + pass + "\" AND UserID = \"" + username + "\";"); // query
            // from
            // DB

            if (rs.next())
                userInformation.append(rs.getString(column));

            connection.close();
            myStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInformation.toString();
    }

    public String getOneUserInfo(int username) throws SQLException {
        createConnection();
        StringBuffer userInformation = new StringBuffer();

        try {

            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery(
                    "SELECT * FROM USER WHERE UserID = \"" + username + "\";"); // query
            // from
            // DB
            if (rs.next())

                userInformation.append(rs.getString("UserID"));
            userInformation.append(" ");

            userInformation.append(rs.getString("Password"));

            connection.close();
            myStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInformation.toString();
    }

    /**
     * Gives the username as argument and returns the permission type of that user
     *
     * @param username
     * @return permissionType
     */
    public String getPermissionType(int username) throws SQLException {
        createConnection();
        String permissionType = "";

        try {
            Statement myStmt = connection.createStatement();
            String[] permissionList = {"Admin", "TEACHER_TECHNICIAN", "CARE_ATTENDANT", "HEALTH_TECHNICIAN",
                    "STUDENT"};
            for (String permission : permissionList) {
                rs = myStmt.executeQuery("SELECT * FROM " + permission + " WHERE UserID = \"" + username + "\";");
                if (rs.next()) {

                    permissionType = rs.getString("Permission");
                    break;
                }
            }

            connection.close();
            myStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionType;
    }

    /**
     * Gets all the information about users exist in the user database
     *
     * @return
     */
    public String adminAccessGetUser() throws SQLException {
        createConnection();
        StringBuffer result = new StringBuffer();
        try {
            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM USER ;");

            while (rs.next())
                result.append(rs.getString("userID") + " " + rs.getString("Password") + "\n");

            connection.close();
            myStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * Getting all the information about all animals from the animal database
     *
     * @return
     */
    public String adminAccessGetAnimal() throws SQLException {
        createConnection();
        StringBuffer result_animal = new StringBuffer();
        try {
            Statement myStmt = connection.createStatement();
            rs = myStmt.executeQuery("SELECT * FROM ANIMAL ;");

            while (rs.next())
                result_animal.append(rs.getString("Animal_ID") + "\n");

            connection.close();
            myStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_animal.toString();
    }

    /**
     * Updates User information in the given column with the given value
     *
     * @param username
     * @param pass
     * @param column
     * @param update
     */
    public void updateUserInfo(String username, String pass, String column, String update) throws SQLException {
        createConnection();
        try {
            Statement myStmt = connection.createStatement();

            myStmt.executeUpdate("UPDATE USER SET " + column + " = \"" + update + " \" WHERE UserID = " + username
                    + " AND Password = " + pass + ";");

            connection.close();
            myStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     * Gets the username and password related to a user in the database and remove
     * that record from the DB
     *
     * @param pass
     */
    public void removeUser(String pass) throws SQLException {
        createConnection();
        try {
            Statement myStmt = connection.createStatement();
            myStmt.executeUpdate("UPDATE USER SET " + "Status = \"" + "Removed" + " \" WHERE Password = " + pass + ";");

            connection.close();
            myStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void blockUser(String pass) throws SQLException {
        createConnection();
        try {
            Statement myStmt = connection.createStatement();
            myStmt.executeUpdate("UPDATE USER SET " + "Status = \"" + "Blocked" + " \" WHERE Password = " + pass + ";");

            connection.close();
            myStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUser(String userID, String fName, String lName, String email, String phone, String birthD) throws SQLException {
        createConnection();
        try {
            Statement myStmt = connection.createStatement();
            myStmt.executeUpdate("UPDATE USER SET " + "Lname = \"" + lName + "\" " + ", Fname = \"" + fName +"\" , Phone = \"" + phone +"\" , Email = \"" + email +"\" , Date_B = \"" + birthD + "\" WHERE UserID = " + userID + ";");
//+ "\" Fname= \"" + fName + "\" Phone= \"" + phone + "\" Email= \"" + email + "\" Date_B= \"" + birthD
            connection.close();
            myStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * addUserToDB() Gets all the information a user must have, and add them into
     * the user database
     *
     * @param status
     * @param password
     * @param lName
     * @param fName
     * @param phone
     * @param email
     * @param sex
     * @param dateB
     * @param activationDate
     * @param permission
     * @throws SQLException
     */
    public void addUserToDB(String status, String password, String lName, String fName, String phone, String email,
                            String sex, String dateB, String activationDate, String permission) throws SQLException {
        createConnection();
        String query = " insert into USER (Status, Password, Lname, Fname, Phone , Email, Sex, Date_B, ActivationDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, status);
        preparedStmt.setInt(2, Integer.parseInt(password));
        preparedStmt.setString(3, lName);
        preparedStmt.setString(4, fName);
        preparedStmt.setString(5, phone);
        preparedStmt.setString(6, email);
        preparedStmt.setString(7, sex);
        preparedStmt.setString(8, dateB);
        preparedStmt.setString(9, activationDate);

        // execute the preparedstatement
        preparedStmt.execute();
        connection.close();
        preparedStmt.close();
    }

    /**
     * Updates the animal status to requested by default
     *
     * @param id
     */
    public void updateAnimalStatusToRequested(int id) throws SQLException {
        createConnection();
        try {
            Statement myStmt = connection.createStatement();

            myStmt.executeUpdate(
                    "UPDATE ANIMAL SET " + "Status = \"" + "Requested" + " \" WHERE Animal_ID = " + id + ";");

            connection.close();
            myStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Updating animal status to a new given status
     *
     * @param id
     * @param status
     */
    public void changeAnimalStatus(int id, String status) throws SQLException {
        createConnection();
        try {
            Statement myStmt = connection.createStatement();

            myStmt.executeUpdate("UPDATE ANIMAL SET " + "Status = \"" + status + " \" WHERE Animal_ID = " + id + ";");

            connection.close();
            myStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
