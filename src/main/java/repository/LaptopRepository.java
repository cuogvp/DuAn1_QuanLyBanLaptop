/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
            TypedQuery<Laptop> query = session.createQuery("FROM Laptop ");
            listsp = query.getResultList();
            session.close();
        }
        return listsp;
    }
    public List<Laptop> getlistLaptop() {
        List<Laptop> lists = new ArrayList<Laptop>();
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "SELECT lt FROM Laptop lt";
            TypedQuery<Laptop> query = session.createQuery(hql, Laptop.class);
            lists = query.getResultList();
        }
        return lists;
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
             session.update(l);
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
    public List<Laptop> findLaptopByName(String ten) {
        List<Laptop> listsp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("select * from Laptop l where l.ten = :ten");
            listsp = query.getResultList();
            session.close();
        }
        return listsp;
        
    }
}
