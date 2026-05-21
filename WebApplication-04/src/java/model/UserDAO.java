/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import utils.DbUtils;
import java.sql.*;

/**
 *
 * @author tungln
 */
public class UserDAO implements IDAO<UserDTO, String> {

    public UserDAO() {
       
    }
    
    // ResultSet → UserDTO
    private UserDTO mapRow(ResultSet rs) throws SQLException {
        return new UserDTO(
            rs.getString("userID"),
            rs.getString("fullName"),
            rs.getString("password"),
            rs.getString("roleID"),
            rs.getBoolean("status")   // BIT → boolean tự động
        );
    }
    

    public boolean add(UserDTO t) {
        return false;
    }

    public boolean remove(UserDTO t) {
        return false;
    }

    public boolean update(UserDTO t) {
        return false;
    }

    public ArrayList<UserDTO> listAll() {
        ArrayList<UserDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM [user]";
        try {
            Connection conn = DbUtils.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // Da lay duoc du lieu tu Table User
            while(rs.next()){
                list.add(mapRow(rs));
            }       
        } catch (Exception e) {
             e.printStackTrace();
        } 
         return list;
    }

    public UserDTO searchByID(String id) {
        String sql = "SELECT * FROM [user] WHERE userID='"+id+"'";
        System.out.println(sql);
        try {
            Connection conn = DbUtils.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            // Da lay duoc du lieu tu Table User
            if(rs.next()){
                return mapRow(rs);
            }       
        } catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }
    
    public boolean checkLogin(String userID, String password){
        UserDTO u = searchByID(userID);
        if(u==null)
            return false;
        
        if(!u.isStatus())
            return false;
        
        if(!u.getPassword().equals(password))
            return false;
        
        return true;
    }
}
