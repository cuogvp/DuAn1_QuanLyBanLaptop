/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.JdbcUltil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author dangc
 */
public class UserRepository {

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
