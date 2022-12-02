/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateConfig;

import java.util.Properties;
import model.BaoHanh;
import model.Hang;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KhuyenMai;
import model.Laptop;
import model.Userr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author dangc
 */
public class HibernateConfig {
    private static final SessionFactory FACTORY;
    
    static {
        org.hibernate.cfg.Configuration conf = new org.hibernate.cfg.Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=duAn1_laptop");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "false");
        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");// tạo bảng trong sql
         
        conf.addAnnotatedClass(Laptop.class);
        conf.addAnnotatedClass(Userr.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(Hang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(BaoHanh.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);


        conf.setProperties(properties);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    public static void main(String[] args) {
        getFACTORY();
    }
}
