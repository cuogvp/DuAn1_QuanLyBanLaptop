/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.KhuyenMai;

/**
 *
 * @author dangc
 */
public interface IKhuyenMaiService {
    List<KhuyenMai> getList();
    String addKM(KhuyenMai km);
    String updateKM(KhuyenMai km);
    String deleteKM(KhuyenMai km);
    List<KhuyenMai> findKhuyenMaiByName(String name);
}
