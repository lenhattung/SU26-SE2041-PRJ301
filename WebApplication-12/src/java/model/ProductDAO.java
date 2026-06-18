/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import utils.JpaUtil;

/**
 *
 * @author Le Nhat Tung
 */
public class ProductDAO implements IDAO<ProductDTO, Integer> {

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

    public boolean add(ProductDTO t) {
        return executeInTransaction(
                em -> em.persist(t)
        );
    }

    public boolean remove(ProductDTO t) {
        return softDelete(t.getId());
    }

    public boolean update(ProductDTO t) {
        return executeInTransaction(
                em -> em.merge(t)
        );
    }

    public ArrayList<ProductDTO> listAll() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return new ArrayList<>(
                    em.createQuery(
                            "SELECT u FROM ProductDTO u",
                            ProductDTO.class
                    ).getResultList()
            );
        } finally {
            em.close();
        }
    }

    public ProductDTO searchByID(Integer id) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            return em.find(ProductDTO.class, id);
        } finally {
            em.close();
        }
    }

    public ArrayList<ProductDTO> searchByName(String name) {
        EntityManager em = JpaUtil.getEntityManager();

        try {

            return new ArrayList<>(
                    em.createQuery(
                            "SELECT u FROM ProductDTO u WHERE u.productName LIKE :name",
                            ProductDTO.class
                    ).setParameter("name", "%" + name + "%").getResultList()
            );

        } finally {
            em.close();
        }
    }

    public boolean softDelete(int id) {
        return executeInTransaction(em -> {

            ProductDTO user = em.find(ProductDTO.class, id);

            if (user == null) {
                throw new RuntimeException("Product not found");
            }

            user.setStatus(false);
        });
    }

    public boolean hardDelete(String userID) {
        return executeInTransaction(em -> {

            ProductDTO user = em.find(ProductDTO.class, userID);

            if (user == null) {
                throw new RuntimeException("Product not found");
            }

            em.remove(user);
        });
    }

}
