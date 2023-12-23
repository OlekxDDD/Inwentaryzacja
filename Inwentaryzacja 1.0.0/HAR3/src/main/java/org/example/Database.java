package org.example;

import java.sql.*;  //import library

public class Database {

    static String url = "jdbc:mysql://localhost:3306/har";  //set server data
    static String user = "root";    //set user
    static String password = "";    //set password
    static Connection connection;   //declare connection
    static Statement statement; //declare statement
    static String sql;  //declare sql prompt

    public static void startQuery(String sql, String user, String password){
        Database.password = password;   //set password
        Database.user = user;   //set user
        Database.sql = sql; //set sql prompt
        CreateConnect();    //create connection
        CreateStatement();  //create statement
        try{
            statement.executeUpdate(sql);   //execute update
        }catch (Exception e){
            System.err.println(e);  //catch exception
        }
    }

    public static ResultSet start(String sql, String user, String password){
        Database.password = password;   //set password
        Database.user = user;   //set user
        Database.sql = sql; //set sql prompt
        CreateConnect();    //create connection
        CreateStatement();  //create statement
        ResultSet resultSet = CreateQuery();    //create resultSet

        return resultSet;   //return resultSet
    }
    static void CreateConnect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  //declare Driver
            connection = DriverManager.getConnection(url, user, password);  //create Connection with Database
        } catch (Exception e) {
            System.out.println(e); //catch Exception
        }
    }
    static Statement CreateStatement(){
        try{
            statement = (Statement) connection.createStatement();   //create Statement
            return statement;   //return Statament
        } catch (SQLException e) {
            throw new RuntimeException(e);  //catch Exception
        }
    }
    public static ResultSet CreateQuery(){
        try {
            ResultSet resultSet = statement.executeQuery(Database.sql); //execute query
            return resultSet;   //return resultSet
        }catch (Exception e) {
            System.out.println(e);  //catch Exception
            return null;
        }
    }
    public static void setUrl(String url) {
        Database.url = url; //set data base Url
    }
}
