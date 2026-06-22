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
        UserDTO u = new UserDTO("Admin10", "Admin", PasswordUtil.hash("12345"), "ADMIN", true, "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");
        UserDAO dao = new UserDAO();
        dao.add(u);
    }
}
