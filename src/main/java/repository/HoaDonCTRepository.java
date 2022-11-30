/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.HoaDonChiTiet;
import hibernateConfig.HibernateConfig;
import hibernateConfig.JdbcUltil;
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
}
