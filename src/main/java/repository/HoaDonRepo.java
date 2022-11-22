package repository;

import hibernateConfig.HibernateConfig;
import java.util.List;
import javax.persistence.TypedQuery;
import model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HoaDonRepo {
       public List<HoaDon> selectAll() {
        List<HoaDon> listhd;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<HoaDon> query = session.createQuery("FROM HoaDon");
            listhd = query.getResultList();
            session.close();
        }
        return listhd;
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
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
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
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
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
}
