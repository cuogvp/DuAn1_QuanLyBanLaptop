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
import model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author dangc
 */
public class HoaDonRepository {

    public List<HoaDon> selectAll() {
        List<HoaDon> listhd;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<HoaDon> query = session.createQuery("FROM HoaDon");
            listhd = query.getResultList();
            session.close();
        }
        return listhd;
    }
    public static void main(String[] args) {
        List<HoaDon> list = new HoaDonRepository().selectAll();
        System.out.println(list);
    }
    public Boolean add(HoaDon hd) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hd);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }

    public Boolean update(HoaDon hd) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(hd);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }

    public Boolean delete(HoaDon hd) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hd);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }

    public UUID findByIdKhachHang(String ten) {
        UUID uuid;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select h.id from KhachHang h where cp.ten = :ten";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ten", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    

    public int genMaHD() {
        String maHD = "";
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            NativeQuery query = session.createNativeQuery("SELECT MAX(CONVERT(INT, SUBSTRING(Ma, 3, 10) )) FROM HoaDon");
            if (query.getSingleResult() != null) {
                maHD = query.getSingleResult().toString();
            } else {
                maHD = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (maHD == null) {
            maHD = "0";
            int ma = Integer.valueOf(maHD);
            return ++ma;
        }
        int ma = Integer.valueOf(maHD);
        return ++ma;
    }
}
