/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tungln
 */
public class UserDAO implements IDAO<UserDTO, String> {
    ArrayList<UserDTO> userList = new ArrayList<UserDTO>();

    public UserDAO() {
        userList.add(new UserDTO("U001", "Nguyen Van An", "1", "R001", true));
        userList.add(new UserDTO("U002", "Tran Thi Bich", "2", "R002", true));
        userList.add(new UserDTO("U003", "Le Hoang Cuong", "Pass@789", "R001", false));
        userList.add(new UserDTO("U004", "Pham Thi Dung", "Pass@321", "R003", true));
        userList.add(new UserDTO("U005", "Hoang Van Em", "Pass@654", "R002", true));
        userList.add(new UserDTO("U006", "Vo Thi Phuong", "Pass@987", "R001", false));
        userList.add(new UserDTO("U007", "Dang Minh Quan", "Pass@111", "R003", true));
        userList.add(new UserDTO("U008", "Bui Thi Huong", "Pass@222", "R002", false));
        userList.add(new UserDTO("U009", "Do Van Khai", "Pass@333", "R001", true));
        userList.add(new UserDTO("U010", "Nguyen Thi Lan", "Pass@444", "R003", true));
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
        return null;
    }

    public UserDTO searchByID(String id) {
        for (UserDTO userDTO : userList) {
            if(userDTO.getUserID().equalsIgnoreCase(id))
                return userDTO;
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
