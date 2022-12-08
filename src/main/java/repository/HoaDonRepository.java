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
import model.HoaDon;
import model.HoaDonChiTiet;
import model.Laptop;
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
            TypedQuery<HoaDon> query = session.createQuery("FROM HoaDon h ORDER BY h.ma DESC");
            listhd = query.getResultList();
            session.close();
        }
        return listhd;
    }

    public List<HoaDonChiTiet> selectAllHoaDonChiTiet() {
        List<HoaDonChiTiet> listhdct;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<HoaDonChiTiet> query = session.createQuery("FROM HoaDonChiTiet hdct");
            listhdct = query.getResultList();
            session.close();
        }
        return listhdct;
    }
    public List<HoaDonChiTiet> selectAllHoaDonChiTiet(String ma) {
        List<HoaDonChiTiet> listhdct;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<HoaDonChiTiet> query = session.createQuery("FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.ma =:ma");
            query.setParameter("ma", ma);
            listhdct = query.getResultList();
            session.close();
        }
        return listhdct;
    }
    public Boolean deleteHDCT(HoaDonChiTiet hdct) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hdct);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public Boolean add(HoaDon hd) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hd);
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
            session.saveOrUpdate(hd);
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
            String statement = "select kh.id from KhachHang kh where kh.ten = :ten";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ten", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    public Boolean addOrUpdateHDCT(HoaDonChiTiet hdct) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(hdct);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }

    public UUID findByIdLaptop(String ma) {
        UUID uuid;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select l.id from Laptop l where l.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ma);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public UUID findByIdHoaDon(String ma) {
        UUID uuid;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select hd.id from HoaDon hd  where hd.ma = :ma";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ma", ma);
            uuid = query.getSingleResult();
        }
        return uuid;
    }
    public UUID findByIdUser(String ten) {
        UUID uuid;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select u.id from Userr u where u.ten = :ten";
            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
            query.setParameter("ten", ten);
            uuid = query.getSingleResult();
        }
        return uuid;
    }

    public List<HoaDon> findAllTrangThai(int trangThai) {
        List<HoaDon> listHD = new ArrayList<>();
        try {
            Session session = HibernateConfig.getFACTORY().openSession();
            String hql = " FROM HoaDon h WHERE h.trangThai = :trangThai";
            Query query = session.createQuery(hql);
            query.setParameter("trangThai", trangThai);
            listHD = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
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
