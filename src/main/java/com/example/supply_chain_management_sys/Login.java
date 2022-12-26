package com.example.supply_chain_management_sys;

import java.sql.ResultSet;

public class Login {
    public boolean customerLogin(String email, String password){
        String query = String.format("SELECT * FROM customers WHERE email = '%s' AND password = '%s'", email , password);
        try {
            DatabaseConnection bdCon = new DatabaseConnection();
            ResultSet rs = bdCon.getQueryTable(query);
            if(rs != null && rs.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
        System.out.println(login.customerLogin("nishantdubey1195@gmail.com", "abcd123"));
    }
}

