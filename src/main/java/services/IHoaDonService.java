/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.HoaDon;
import model.HoaDonChiTiet;

/**
 *
 * @author dangc
 */
public interface IHoaDonService {
    ArrayList<HoaDon> getList();
    String addHd(HoaDon hd);
    String deleteHd(HoaDon hd);
    String updateHd(HoaDon hd);
    UUID findByIdKhachHang(String ten);
    UUID findByIdUser(String ten);
    List<HoaDon> findAllTrangThai(int trangThai);
    public int genMaHD();
    List<HoaDonChiTiet> selectAllHoaDonChiTiet();
    Boolean addOrUpdateHDCT(HoaDonChiTiet hdct);
    UUID findByIdLaptop(String ma);
    UUID findByIdHoaDon(String ma);
    List<HoaDonChiTiet> selectAllHoaDonChiTiet(String ma);
}
