package repository;

import hibernateConfig.HibernateConfig;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Laptop;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author toten
 */
public class TTSPrepo {
    public List<Laptop> selectAll() {
        List<Laptop> listTtSp;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            TypedQuery<Laptop> query = session.createQuery("FROM Laptop");
            listTtSp = query.getResultList();
            session.close();
        }
        return listTtSp;
    }
//   public Boolean add(TTSP ttsp) {
//        Transaction transaction = null;
//        boolean check = false;
//        try (Session session = HibernateConfig.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(ttsp);
//            transaction.commit();
//            check = true;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        }
//        return check;
//    }
//   
//    
//    public Boolean update(TTSP ttsp) {
//        Transaction transaction = null;
//        boolean check = false;
//        try (Session session = HibernateConfig.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//             session.update(ttsp);
//            transaction.commit();
//            check = true;
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        }
//        return check;
//    }
//    public Boolean delete(TTSP ttsp) {
//        Transaction transaction = null;
//        boolean check = false;
//        try (Session session = HibernateConfig.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//             session.delete(ttsp);
//            transaction.commit();
//            check = true;
//            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            transaction.rollback();
//        }
//        return check;
//    }
   
}
