/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Laptop;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dangc
 */
public class LaptopRepository {
    public List<Laptop> selectAll() {
        List<Laptop> listsp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("FROM Laptop l");
            listsp = query.getResultList();
            session.close();
        }
        return listsp;
    }
   public Boolean addLaptop(Laptop l) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(l);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
   
    
    public Boolean updateLaptop(Laptop l) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.saveOrUpdate(l);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public Boolean delete(Laptop l) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.delete(l);
            transaction.commit();
            check = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public UUID findByIdHang(String ten) {
        UUID uuid;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select h.id from Hang h where h.ten = :ten";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ten", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
   
    public List<Laptop> findAllByName(String name) {
        List<Laptop> list = new ArrayList<>();
        try {
            Session session = HibernateConfig.getFACTORY().openSession();
            String hql =" FROM Laptop l WHERE l.ten LIKE :name";
            Query query = session.createQuery(hql);
            query.setParameter("name","%"+ name+"%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Laptop> countLaptopByTrangThai() {
        List<Laptop> listsp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("FROM  Laptop l WHERE l.trangThai =1");
            listsp = query.getResultList();
            session.close();
        }
        return listsp;
    }
    public List<Laptop> countLaptopByTrangThaiDBan() {
        List<Laptop> listsp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("FROM  Laptop l WHERE l.trangThai =0");
            listsp = query.getResultList();
            session.close();
        }
        return listsp;
    }
    public List<Laptop> countLaptopByTrangThaiTon() {
        List<Laptop> listsp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("FROM  Laptop l WHERE l.trangThai =2");
            listsp = query.getResultList();
            session.close();
        }
        return listsp;
    }
}
