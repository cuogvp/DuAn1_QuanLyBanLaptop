/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.List;
import javax.persistence.TypedQuery;
import model.KhuyenMai;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dangc
 */
public class KhuyenMaiRepository {
    public List<KhuyenMai> selectAll() {
        List<KhuyenMai> listKm;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<KhuyenMai> query = session.createQuery("FROM KhuyenMai km");
            listKm = query.getResultList();
            session.close();
        }
        return listKm;
    }
    
    public Boolean addKhuyenMaiRepo(KhuyenMai km) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(km);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    
    public Boolean updateKhuyenMaiRepo(KhuyenMai km) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.update(km);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public Boolean deleteKhuyenMaiRepo(KhuyenMai km) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.delete(km);
            transaction.commit();
            check = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
}
