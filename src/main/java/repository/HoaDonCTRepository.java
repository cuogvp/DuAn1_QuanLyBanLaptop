/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.HoaDonChiTiet;
import hibernateConfig.HibernateConfig;
import hibernateConfig.JdbcUltil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author dangc
 */
public class HoaDonCTRepository {
    public List<HoaDonChiTiet> selectAll() {
        List<HoaDonChiTiet> listHoaDonCT;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<HoaDonChiTiet> query = session.createQuery("FROM HoaDonChiTiet ct");
            listHoaDonCT = query.getResultList();
            session.close();
        }
        return listHoaDonCT;
    }
    // tin
    public BigDecimal doanhThuTheoNgay(){
        BigDecimal result = null;
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("SELECT SUM(HoaDonChitiet.SoLuong*DonGia) AS DoanhThu From HoaDonChiTiet\n"
                    +"join HoaDon on HoaDonChiTiet.IDHoaDon = HoaDon.ID Where\n"
                    + "HoaDonChitiet.SoLuong >0 AND HoaDonChitiet.TrangThai = 1\n"
                    + "And DAY(HoaDon.NgayNhanHang) = Day(GETDATE())");
            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }
    
    public BigDecimal doanhThuTheoThang(int thang){
        BigDecimal result = null;
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("SELECT SUM(HoaDonChitiet.SoLuong*DonGia) AS DoanhThu From HoaDonChiTiet\n"
                    +"join HoaDon on HoaDonChiTiet.IDHoaDon = HoaDon.ID Where\n"
                    + "HoaDonChitiet.SoLuong >0 AND HoaDonChitiet.TrangThai = 1\n"
                    + "And MONTH(HoaDon.NgayNhanHang) = " +thang);
            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }
    public BigDecimal doanhThuTheoNam(){
        BigDecimal result = null;
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("SELECT SUM(HoaDonChitiet.SoLuong*DonGia) AS DoanhThu From HoaDonChiTiet\n"
                    +"join HoaDon on HoaDonChiTiet.IDHoaDon = HoaDon.ID Where\n"
                    + "HoaDonChitiet.SoLuong >0 AND HoaDonChitiet.TrangThai = 1\n"
                    + "And YEAR(HoaDon.NgayNhanHang )= YEAR(GETDATE())");
            result = (BigDecimal) query.getResultList().get(0);
            transaction.commit();
        }
        return result;
    }
}
