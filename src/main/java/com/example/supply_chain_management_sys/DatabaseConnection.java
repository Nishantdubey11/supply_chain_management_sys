package com.example.supply_chain_management_sys;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;


public class DatabaseConnection {
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/supply_chain";
    private static final String userName = "root";
    private static final String password = "Root@123";

    public Statement getStatement(){
        Statement statement = null;
        Connection conn;
        try{
            conn = DriverManager.getConnection(databaseUrl, userName, password);
            statement = conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet getQueryTable(String query){
        Statement statement = getStatement();
        try{
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ResultSet rs = databaseConnection.getQueryTable("select email, first_name from customers");
        try{
            while(rs.next()){
                System.out.println(rs.getString("email") + " " + rs.getString("first_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
