/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import utils.JpaUtil;

/**
 *
 * @author tungln
 */
public class UserDAO implements IDAO<UserDTO, String> {

    public UserDAO() {
    }

    private boolean executeInTransaction(
            java.util.function.Consumer<EntityManager> action) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            action.accept(em);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean add(UserDTO t) {
        return executeInTransaction(
                em -> em.persist(t)
        );
    }

    public boolean remove(UserDTO t) {
        return softDelete(t.getUserID());
    }

    public boolean update(UserDTO t) {
        return executeInTransaction(
                em -> em.merge(t)
        );
    }

    public ArrayList<UserDTO> listAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return new ArrayList<>(
                    em.createQuery(
                            "SELECT u FROM UserDTO u",
                            UserDTO.class
                    ).getResultList()
            );
        } finally {
            em.close();
        }
    }

    public UserDTO searchByID(String id) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            return em.find(UserDTO.class, id);
        } finally {
            em.close();
        }
    }

    public ArrayList<UserDTO> searchByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();

        try {

            return new ArrayList<>(
                    em.createQuery(
                            "SELECT u FROM UserDTO u WHERE u.fullName LIKE :name",
                            UserDTO.class
                    ).setParameter("name", "%" + name + "%").getResultList()
            );

        } finally {
            em.close();
        }
    }

    public boolean checkLogin(String userID, String password) {
        UserDTO u = searchByID(userID);
        if (u == null) {
            return false;
        }

        if (!u.isStatus()) {
            return false;
        }

        if (!u.getPassword().equals(password)) {
            return false;
        }

        return true;
    }

    public boolean softDelete(String userID) {
        return executeInTransaction(em -> {

            UserDTO user = em.find(UserDTO.class, userID);

            if (user == null) {
                throw new RuntimeException("User not found");
            }

            user.setStatus(false);
        });
    }

    public boolean hardDelete(String userID) {
        return executeInTransaction(em -> {

            UserDTO user = em.find(UserDTO.class, userID);

            if (user == null) {
                throw new RuntimeException("User not found");
            }

            em.remove(user);
        });
    }
}
