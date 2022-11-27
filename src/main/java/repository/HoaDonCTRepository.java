/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.TypedQuery;
import model.HoaDon;
import model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dangc
 */
public class HoaDonCTRepository {
    
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
    public BigDecimal findByGia(String ma) {
        BigDecimal gia;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            String statement = "select l.giaBan from Laptop l where l.ma = :ma";
            TypedQuery<BigDecimal> query = session.createQuery(statement, BigDecimal.class);
            query.setParameter("ma", ma);
            gia = query.getSingleResult();
        }
        return gia;
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
    
}
