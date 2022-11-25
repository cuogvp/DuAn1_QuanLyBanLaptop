/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernateConfig.HibernateConfig;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Laptop;
import org.hibernate.Session;

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
}
