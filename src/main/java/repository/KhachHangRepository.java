/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.KhachHang;
import model.Laptop;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dangc
 */
public class KhachHangRepository {
      public List<KhachHang> selectAll() {
        List<KhachHang> listUs;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<KhachHang> query = session.createQuery("FROM KhachHang ");
            listUs = query.getResultList();
            session.close();
        }
        return listUs;
    }
    
    public Boolean addUserrRepo(KhachHang kh) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    
    public Boolean updateUserrRepo(KhachHang kh) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.update(kh);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public Boolean deleteUserrRepo(KhachHang kh) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.delete(kh);
            transaction.commit();
            check = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public List<KhachHang> findAllByName(String name) {
        List<KhachHang> listKH = new ArrayList<>();
        try {
            Session session = HibernateConfig.getFACTORY().openSession();
            String hql =" FROM KhachHang l WHERE l.ten LIKE :name";
            Query query = session.createQuery(hql);
            query.setParameter("name","%"+ name+"%");
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
}
