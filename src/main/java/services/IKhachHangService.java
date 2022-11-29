/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author dangc
 */
public interface IKhachHangService {
    List<KhachHang> selectAll();
    String addKH(KhachHang kh);
    String updateKH(KhachHang h);
    String deleteKH(KhachHang kh);
    List<KhachHang> findAllByName(String name);
}
