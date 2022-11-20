/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import hibernateConfig.JdbcUltil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import model.User;
import model.Userr;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dangc
 */
public class UserRepository {
    public List<Userr> selectAll() {
        List<Userr> listUs;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Userr> query = session.createQuery("FROM Userr ");
            listUs = query.getResultList();
            session.close();
        }
        return listUs;
    }
   public Boolean addUserrRepo(Userr u) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(u);
            transaction.commit();
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
   
    
    public Boolean updateUserrRepo(Userr u) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.update(u);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    public Boolean deleteUserrRepo(Userr u) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
             session.delete(u);
            transaction.commit();
            check = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
    
    public ArrayList<User> getAllRepoStory() {
        ArrayList<User> list = new ArrayList<>();
        try {
            Connection conn = JdbcUltil.getConnection();
            String sSQL = "SELECT * FROM Userr";
            PreparedStatement sttm = conn.prepareStatement(sSQL);
            sttm.execute();
            ResultSet rs = sttm.getResultSet();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getString(1));
                u.setMa(rs.getString(2));
                u.setTen(rs.getString(3));
                u.setMatKhau(rs.getString(4));
                u.setGioiTinh(rs.getBoolean(5));
                u.setNgaySinh(rs.getString(6));
                u.setDiaChi(rs.getString(7));
                u.setSdt(rs.getString(8));
                u.setChuVu(rs.getString(9));
                u.setHinhAnh(rs.getString(10));
                u.setIdCH(rs.getString(11));
                list.add(u);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public User checkLogin(String ma, String password) {
        User u = new User();
        Connection conn = JdbcUltil.getConnection();
        String sql = "SELECT * FROM Userr WHERE Ma=? AND MatKhau=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                u = new User(rs.getString("Ma"), rs.getString("MatKhau"),
                        rs.getString("ChucVu"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return u;
    }

    
}
