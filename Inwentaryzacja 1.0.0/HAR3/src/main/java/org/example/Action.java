package org.example;

import java.sql.ResultSet;  //import library
import java.util.ArrayList;
import java.util.List;
import static java.lang.Character.isDigit;
public class Action {
    static public List<List<String>> LatestPrompt = new ArrayList<>();  //declare List fo Lists
    public static View view;    // declare Object view

    public static void addItem(String ID_K,String Name,String Opis, String Wartosc, String ilosc) { //declare method
        String sql = "INSERT INTO `item`(`ID_K`, `Name`, `Description`, `Value`, `Amount`) VALUES (" +ID_K+ "," +Name+ ","+Opis+","+Wartosc+"," + ilosc + ")";    //create sql prompt
        try {
            Database.startQuery(sql, "root", "");   //execute query
            System.out.println("item dodany");  //view information
        }catch (Exception e ){
            System.err.println(e);  //catch errors
        }
    }

    public static void seeAllColours() {
        LatestPrompt.clear();   //Clear LatestPrompt
        try{
            ResultSet resultSet = Database.start("Select * From kolory","root",""); //get resultSet
            while (resultSet.next()){   //itarate resultSet
                List<String> record = new ArrayList<>();    //create record List
                record.add(resultSet.getString("ID_K"));    //get ID_K
                record.add(resultSet.getString("Name"));   //get Name
                LatestPrompt.add(record);   //add record to LatestPrompt
            }
        }catch (Exception e){
            System.err.println("error: "+e);    //catch Exception
        }
        Main.view.dispose();    //dispose What Do
        view = new View("ViewIt");  //View All colours with View it
    }

    public static void seeAllItem() {
        LatestPrompt.clear();   //Clear LatestPrompt
        try{
            String sql = "SELECT ID_I,kolory.Name,item.Name, Description , Value , Amount FROM item LEFT JOIN kolory ON item.ID_K = kolory.ID_K;";
            ResultSet resultSet = Database.start(sql,"root","");   //get resultSet
            while (resultSet.next()) {  //itarate resultSet
                List<String> record = new ArrayList<>();    //create record
                record.add(resultSet.getString("ID_I"));    //get ID_I
                record.add(resultSet.getString(2));    //get ID_K
                record.add(resultSet.getString(3));    //get Name
                record.add(resultSet.getString("Description"));    //get Description
                record.add(resultSet.getString("Value"));    //get Value
                record.add(resultSet.getString("Amount"));  //get Amount
                LatestPrompt.add(record);   //Add record to LatestPrompt
            }
        }catch (Exception e){
            System.err.println("error: "+e);    // catch Exception
        }
        Main.view.dispose();    // dispose What Do in Main
        view = new View("ViewIt");  //View All items with View it
    }

    static boolean isDigitString(@org.jetbrains.annotations.NotNull String string){
        for (int i = 0; i < string.length(); i++) {
            if(!(isDigit(string.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public static void addColour(String ID_K, String Name) {
        String sql = "INSERT INTO kolory (`ID_K`, `Name`) VALUES (" +ID_K+ "," +Name+")";    //create sql prompt
        try {
            Database.startQuery(sql, "root", "");   //execute query
            System.out.println("colour dodany");  //view information
        }catch (Exception e ){
            System.err.println(e);  //catch errors
        }
    }
    public static void ExecuteQuery(String sql){
        System.out.println("Execute Query in");
        try {
            Database.startQuery(sql, "root", "");   //execute query
            System.out.println("execute Query done!");  //view information
        }catch (Exception e ){
            System.err.println(e);  //catch errors
        }
        System.out.println("Execute Query exit");
    }


    public static boolean isLessThanMaxText(String Text){
        if(Text.length() > 65535){
            return false;
        }else{
            return true;
        }
    }
}