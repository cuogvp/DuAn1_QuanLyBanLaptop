
import hibernateConfig.HibernateConfig;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class HoaDonChiTiet {
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
