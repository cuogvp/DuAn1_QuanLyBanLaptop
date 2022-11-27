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
import model.HoaDon;
import model.Laptop;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author dangc
 */
public class TTSPRepository {
    public List<Laptop> selectAll() {
        List<Laptop> listTtSp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("FROM Laptop");
            listTtSp = query.getResultList();
            session.close();
        }
        return listTtSp;
    }
    public List<Laptop> findAllByName(String name) {
        List<Laptop> list = new ArrayList<>();
        try {
            Session session = HibernateConfig.getFACTORY().openSession();
            String hql =" FROM Laptop l WHERE l.ten LIKE :name";
            Query query = session.createQuery(hql);
            query.setParameter("name","%"+ name+"%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Boolean update(Laptop l) {
        Transaction transaction = null;
        boolean check = false;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(l);
            transaction.commit();
            check = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return check;
    }
}
