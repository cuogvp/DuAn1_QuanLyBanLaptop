/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.TypedQuery;
import model.Hang;
import model.Laptop;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernateConfig.HibernateConfig;

/**
 *
 * @author dangc
 */
public class HangRepository {
     public List<Hang> selectAll() {
        List<Hang> listHang;
        try ( Session session =HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Hang> query = session.createQuery("FROM Hang");
            listHang = query.getResultList();
            session.close();
        }
        return listHang;
    }
   public Boolean addHang(Hang h) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(h);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
   
    
    public Boolean updateHang(Hang h) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.saveOrUpdate(h);;
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public Boolean deleteHang(Hang h) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.delete(h);
            transaction.commit();
            check = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
}
