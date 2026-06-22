/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.UserDAO;
import model.UserDTO;

public class JpaUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("WebApplication-13PU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public static void main(String[] args) {
        UserDTO u = new UserDTO("Admin3", "Admin", PasswordUtil.hash("12345"), "ADMIN", true);
        UserDAO dao = new UserDAO();
        dao.add(u);
    }
}
